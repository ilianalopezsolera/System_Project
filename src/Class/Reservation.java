package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 * Represents a reservation made for a sport space. This class stores the 
 * details of a reservation, including the date, time, space name, user 
 * information, and confirmation status. It also provides methods for creating 
 * reservations and sending booking confirmations.
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
public class Reservation {

    private String date;

    private String time;

    private String sportSpace;

    private boolean confirmation;

    private User user;

    public Reservation() {
    }

    public Reservation(String date, String time, String sportSpace,
            boolean confirmation, User user) {
        this.date = date;
        this.time = time;
        this.sportSpace = sportSpace;
        this.confirmation = confirmation;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSportSpace() {
        return sportSpace;
    }

    public void setSportSpace(String sportSpace) {
        this.sportSpace = sportSpace;
    }

    public boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Creates a reservation for a given sport space if it's available.
     * 
     * <p>This method allows a user to create a reservation for a sport space 
     * by entering their details and selecting a date and time. The reservation 
     * details are then saved to the history file and the space's availability 
     * is updated in the calendar file.</p>
     * 
     * @param sportSpace the sport space to reserve
     * @param language the language used for interaction (e.g., "es" for Spanish)
     * @return true if the reservation was successful, false otherwise
     */
    public boolean createReservation(SportSpace sportSpace, String language) {
        Scanner scanner = new Scanner(System.in);
        boolean confirmationReservation = false;
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        
        String spaceName = "";
        String name = "";
        String identifier = "";
        long number = 0;
        String mail = "";
        boolean reservation = false;
        String dateReservation = "";
        String timeReservation = "";

        File inputFile = new File("Calendario reservas.txt");
        File tempFile = new File("tempFile.txt");

        System.out.print(messages.getString("spaceNamePrompt"));
        spaceName = scanner.nextLine();

        if (sportSpace.seeAvailability(spaceName, language)) {
            System.out.println();
            System.out.println(messages.getString("reserveAs"));
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print(messages.getString("namePrompt"));
                    name = scanner.nextLine();

                    System.out.print(messages.getString("carnetPrompt"));
                    identifier = scanner.next();
                    scanner.nextLine();

                    System.out.print(messages.getString("phonePrompt"));
                    number = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print(messages.getString("emailPrompt"));
                    mail = scanner.next();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print(messages.getString("namePrompt"));
                    name = scanner.nextLine();

                    System.out.print(messages.getString("idPrompt"));
                    identifier = scanner.next();
                    scanner.nextLine();

                    System.out.print(messages.getString("phonePrompt"));
                    number = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print(messages.getString("emailPrompt"));
                    mail = scanner.next();
                    scanner.nextLine();
                    break;
                default:
                    break;
            }

            Contact contact = new Contact(mail, number);
            User user = new User(name, identifier, contact);
            System.out.println();
            
            do {
                System.out.println(messages.getString("chooseDateTime"));

                System.out.print(messages.getString("datePrompt"));
                dateReservation = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("timePrompt"));
                timeReservation = scanner.next();
                scanner.nextLine();

                Reservation newReservation = new Reservation(dateReservation, timeReservation, spaceName, true, user);

                //Se registra la informacion del espacio deportivo y el usuario en el historial de reservas.
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial sistema de reservas.txt", true))) {
                    writer.write(newReservation.toString());
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println(messages.getString("errorRegistering"));
                    e.printStackTrace();
                }

                //Cambiar el estado de disponible a mo disponible en el calendario
                try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        if (line.contains(spaceName) && line.contains(dateReservation) && line.contains(timeReservation)) {
                            line = line.replace("true", "false");
                            confirmationReservation = true;
                        }
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println(messages.getString("errorProcessFile"));
                    e.printStackTrace();
                }

                // Reemplazar el archivo original con el archivo temporal
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.out.println(messages.getString("errorREnamingTempFil"));
                    } else {
                        System.out.println(messages.getString("reservationSuccessful"));
                        newReservation.sendConfirmation();
                    }
                } else {
                    System.out.println(messages.getString("errorDeleteInputFile"));
                }

                System.out.println();
                System.out.println(messages.getString("anotherReservation"));
                option = scanner.nextInt();

            } while (option == 1);
        }
        return confirmationReservation;
    }

    /**
     * Send a booking confirmation by email to the user.
     * 
     * <p>This method uses the JavaMail API to send a confirmation email to the 
     * email address provided. The email contains information about the 
     * reservation made in the reservation system of sports venues.</p>
     * 
     */
    public void sendConfirmation() {
        // Dirección de correo y credenciales
        String to = "dilangonzalez2517@gmail.com"; // Cambia esto con el destinatario
        String from = "proyectoprogra29@gmail.com"; // Tu correo de Gmail
        String password = "rygo gjzq aeam gqpc"; // Tu contraseña de Gmail

        // Configuración de las propiedades del correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Crear una sesión de correo autenticada
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Sistema de Reservas de Espacios Deportivos UCR");
            message.setText("Se ha confirmado su reserva.");

            // Enviar el correo
            Transport.send(message);
            System.out.println("Se ha enviado un correo con la confirmacion de su reserva.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public String toString() {
        return "Reservation " + "date: " + date + ", time: " + time
                + ", sport space: " + sportSpace + ", confirmation: " + confirmation
                + ", user " + user;
    }

}

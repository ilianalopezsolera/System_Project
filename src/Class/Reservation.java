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

    public boolean createReservation(SportSpace sportSpace) {
        Scanner scanner = new Scanner(System.in);
        boolean confirmationReservation = false;
        
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

        System.out.print("Nombre del espacio deportivo: ");
        spaceName = scanner.nextLine();

        if (sportSpace.seeAvailability(spaceName)) {
            System.out.println();
            System.out.println("----- RESERVA COMO -----");
            System.out.println("1. Estudiante. \n2. Personal.");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    name = scanner.nextLine();

                    System.out.print("Carnet: ");
                    identifier = scanner.next();
                    scanner.nextLine();

                    System.out.print("Numero de telefono: ");
                    number = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Direccion de correo: ");
                    mail = scanner.next();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    name = scanner.nextLine();

                    System.out.print("Identificacion: ");
                    identifier = scanner.next();
                    scanner.nextLine();

                    System.out.print("Numero de telefono: ");
                    number = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Direccion de correo: ");
                    mail = scanner.next();
                    scanner.nextLine();
                    break;
                default:
                    break;
            }

            Contact contact = new Contact(mail, number);
            User user = new User(name, identifier, contact);

            do {
                System.out.println("Escoja una fecha y hora");

                System.out.print("Fecha: ");
                dateReservation = scanner.next();
                scanner.nextLine();

                System.out.print("Hora: ");
                timeReservation = scanner.next();
                scanner.nextLine();

                Reservation newReservation = new Reservation(dateReservation, timeReservation, spaceName, true, user);

                //Se registra la informacion del espacio deportivo y el usuario en el historial de reservas.
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial sistema de reservas.txt", true))) {
                    writer.write(newReservation.toString());
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Error al registrar la reserva.");
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
                    System.out.println("Error al procesar el archivo");
                    e.printStackTrace();
                }

                // Reemplazar el archivo original con el archivo temporal
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.out.println("Error al renombrar el archivo temporal.");
                    } else {
                        System.out.println("Espacio reservado correctamente.");
                        newReservation.sendConfirmation();
                    }
                } else {
                    System.out.println("Error al eliminar el archivo original.");
                }

                System.out.println();
                System.out.println("1. Realizar otra reserva. \n2. Salir.");
                option = scanner.nextInt();

            } while (option == 1);
        }
        return confirmationReservation;
    }

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

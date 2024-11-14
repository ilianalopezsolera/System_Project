package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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

    public boolean createReservation(Reservation reservation, SportSpace[] sportSpaces, String spaceName, String date, String time) {
        boolean successful = false;
        for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].getName().equals(spaceName) && sportSpaces[i].getDate().equals(date)
                    && sportSpaces[i].getTime().equals(time)) {
                sportSpaces[i].setAvailability(false);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial"
                        + " sistema de reservas.txt", true))) { // Modo append
                    writer.write(reservation.toString());
                    writer.newLine(); // Añadir un salto de línea después de cada reserva
                    successful = true;
                } catch (IOException e) {
                    System.out.println("Error al guardar la reservación: " + e.getMessage());
                }
            }
        }
        return successful;
    }

    public Reservation[] reservationList() {
        Reservation[] reservations = new Reservation[156]; // Ajusta el tamaño según la cantidad de registros en el archivo
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Historial sistema de reservas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Omite la primera línea del archivo si es un encabezado

                // Parseo de la línea
                String[] partes = linea.split(", ");
                String date = partes[0].split(": ")[1].trim();
                String time = partes[1].split(": ")[1].trim();
                String sportSpace = partes[2].split(": ")[1].trim();
                boolean confirmation = Boolean.parseBoolean(partes[3].split(": ")[1]);
                String name = partes[4].split(": ")[1].trim();
                String identifier = partes[5].split(": ")[1].trim();
                String mail = partes[6].split(": ")[1].trim();
                long phone = Long.parseLong(partes[7].split(": ")[1]);

                Contact contact = new Contact(mail, phone);
                User user = new User(name, identifier, contact);
                // Crear y agregar el objeto SportSpace al arreglo
                reservations[index++] = new Reservation(date, time, sportSpace, confirmation, user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public void deleteReservation(Reservation[] reservationList, String date, String time, String sportSpace) {
        for (int i = 0; i < reservationList.length; i++) {
            if (reservationList[i] == null) {
                i = reservationList.length;
            } else if (reservationList[i].getDate().equalsIgnoreCase(date)
                    && reservationList[i].getTime().equalsIgnoreCase(time)
                    && reservationList[i].getSportSpace().equalsIgnoreCase(sportSpace)) {
                reservationList[i].setConfirmation(false);
                System.out.println("Cancelacion exitosa");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial sistema de reservas.txt"))) {
                    // Escribir todas las reservas actuales, incluyendo la actualizada
                    for (int j = 0; j < reservationList.length; j++) {
                        if (reservationList[i] == null) {
                            return;
                        } else {
                            // Asumiendo que Reservation tiene un método toString que formatea correctamente
                            writer.write(reservationList[j].toString());
                            writer.newLine(); // Escribe una nueva línea
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al guardar los cambios en el archivo: " + e.getMessage());
                }

                return;
            }
        }
        System.out.println("No se encontro la reservacion");
    }

    public void sendConfirmation() {
    }

    @Override
    public String toString() {
        return "Reservation " + "date: " + date + ", time: " + time
                + ", sport space: " + sportSpace + ", confirmation: " + confirmation
                + ", user " + user;
    }

}

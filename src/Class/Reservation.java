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

//    public boolean createReservation(Reservation reservation, SportSpace[] sportSpaces, String spaceName, String date, String time) {
//        boolean successful = false;
//        for (int i = 0; i < sportSpaces.length; i++) {
//            if (sportSpaces[i].getName().equals(spaceName) && sportSpaces[i].getDate().equals(date)
//                    && sportSpaces[i].getTime().equals(time)) {
//                sportSpaces[i].setAvailability(false);
//
//                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial"
//                        + " sistema de reservas.txt", true))) { // Modo append
//                    writer.write(reservation.toString());
//                    writer.newLine(); // Añadir un salto de línea después de cada reserva
//                    successful = true;
//                } catch (IOException e) {
//                    System.out.println("Error al guardar la reservación: " + e.getMessage());
//                }
//            }
//        }
//        return successful;
//    }

    public void createReservation(Reservation reservation, String spaceName, String date, String time){

        try{
            FileReader reader = new FileReader("Calendario reservas.txt");
            BufferedReader br = new BufferedReader(reader);
            
            String line;
            
            while((line = br.readLine()) != null){
                if (line.contains(spaceName) && line.contains(date)
                        && line.contains(time)) {
                    line = line.replace("true", "false");
                    System.out.println(line);
                    
                    try{
                        FileWriter writer = new FileWriter("Historial sistema de reservas.txt", true);
                        BufferedWriter bw = new BufferedWriter(writer);
                        
                        bw.write(reservation.toString());
                        bw.newLine();
                        
                    }catch(IOException e){
                        System.out.println("Error al guardar la reservación: " + e.getMessage());
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo" + e.getMessage());
        }
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

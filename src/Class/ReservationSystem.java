package Class;

import java.util.*;

public class ReservationSystem {

    private SportSpace[] spaces = new SportSpace[10];

    private Admin admin;

    private Reservation[] reservation;

    public ReservationSystem() {
    }

    public ReservationSystem(SportSpace[] spaces, Admin admin, Reservation[] reservation) {
        this.spaces = spaces;
        this.admin = admin;
        this.reservation = reservation;
    }

    public SportSpace[] getSpaces() {
        return spaces;
    }

    public void setSpaces(SportSpace[] spaces) {
        this.spaces = spaces;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Reservation[] getReservation() {
        return reservation;
    }

    public void setReservation(Reservation[] reservation) {
        this.reservation = reservation;
    }

    public boolean verifyPassword(Admin[] adminList) {
        String password;
        int attempts = 3;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Intento " + attempts);
            System.out.print("Digite su contraseña: ");
            password = scanner.next();
            scanner.nextLine();

            for (int i = 0; i < adminList.length; i++) {
                if (adminList[i].getCarnet().equalsIgnoreCase(password)) {
                    System.out.println("Bienvenido " + adminList[i].getName());
                    return true;
                }
            }
            System.out.println("Contraseña no valida");
            attempts--;
        } while (attempts > 0);
        return false;
    }

    public void manageReservations() {
    }

    public void saveData() {
    }

    public void register() {
    }

    public Reservation getHistory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sendNotification() {
    }

    @Override
    public String toString() {
        return "ReservationSystem " + "spaces: " + spaces + ", admin: " + admin
                + ", reservation: " + reservation;
    }

}

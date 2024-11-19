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

    public boolean verifyPassword(Admin[] adminList, String language) {
        String password;
        int attempts = 3;
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        do {
            System.out.println(messages.getString("intent")+ attempts);
            System.out.print(messages.getString("enterPassword"));
            password = scanner.next();
            scanner.nextLine();

            for (int i = 0; i < adminList.length; i++) {
                if (adminList[i].getCarnet().equalsIgnoreCase(password)) {
                    System.out.println(messages.getString("welcome") + adminList[i].getName());
                    return true;
                }
            }
            System.out.println(messages.getString("invalidPassword"));
            attempts--;
        } while (attempts > 0);
        return false;
    }

    @Override
    public String toString() {
        return "ReservationSystem " + "spaces: " + spaces + ", admin: " + admin
                + ", reservation: " + reservation;
    }

}

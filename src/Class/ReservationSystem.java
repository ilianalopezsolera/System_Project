package Class;

import java.util.*;

/**
 * Represents a reservation system for managing sport spaces, verifying 
 * administrator access, and handling reservations. The system stores a list 
 * of sport spaces, a list of administrators, and a list of reservations.
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
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

    /**
     * Verify the password entered by the user by comparing it with the 
     * administrators cards. The user has a limited number of attempts to enter 
     * the correct password.
     * 
     * <p>If the card entered is correct, the system welcomes the corresponding
     * administrator. If it is incorrect, a limited number of attempts are 
     * allowed.</p>
     * 
     * @param adminList An array of Admin objects that contains the list of 
     * administrators.
     * @param language the language used for interaction (e.g., "es" for Spanish)
     * @return true if the card entered coincides with one of the administrators;
     * false if attempts have timed out or the password is incorrect.
     */
    public boolean verifyPassword(Admin[] adminList, String language) {
        String password;
        int attempts = 3;
        int contAttempts = 1;
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        do {
            System.out.println(messages.getString("intent") + contAttempts);
            System.out.print(messages.getString("enterPassword"));
            password = scanner.next();
            scanner.nextLine();

            for (int i = 0; i < adminList.length; i++) {
                if (adminList[i].getCarnet().equalsIgnoreCase(password)) {
                    System.out.println();
                    System.out.println(messages.getString("welcome") + adminList[i].getName());
                    System.out.println();
                    return true;
                }
            }
            System.out.println(messages.getString("invalidPassword"));
            attempts--;
            contAttempts++;
        } while (attempts > 0);
        return false;
    }

    @Override
    public String toString() {
        return "ReservationSystem " + "spaces: " + spaces + ", admin: " + admin
                + ", reservation: " + reservation;
    }

}

package System;

public class ReservationSystem {

    private SportSpace[] spaces;

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
        return "ReservationSystem{" + "spaces=" + spaces + ", admin=" + admin +
                ", reservation=" + reservation + '}';
    }
    
}

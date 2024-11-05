package System;

import java.util.Date;

public class Reservation {

    private Date date;

    private Date time;

    private SportSpace sportSpace;

    private boolean confirmation;

    private User user;

    public Reservation() {
    }

    public Reservation(Date date, Date time, SportSpace sportSpace, boolean confirmation, User user) {
        this.date = date;
        this.time = time;
        this.sportSpace = sportSpace;
        this.confirmation = confirmation;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public SportSpace getSportSpace() {
        return sportSpace;
    }

    public void setSportSpace(SportSpace sportSpace) {
        this.sportSpace = sportSpace;
    }

    public boolean isConfirmation() {
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
    
    public void createReservation() {
    }

    public void cancelReservation() {
    }

    public void sendConfirmation() {
    }

    @Override
    public String toString() {
        return "Reservation{" + "date=" + date + ", time=" + time +
                ", sportSpace=" + sportSpace + ", confirmation=" +
                confirmation + ", user=" + user + '}';
    }
    
}

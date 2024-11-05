package System;

public class Admin extends Person {

    private String ID;

    public Admin() {
    }

    public Admin(String ID) {
        this.ID = ID;
    }
    
    public void addReservation() {
    }

    public void removeReservation() {
    }

    public void modifyReservation() {
    }

    public void seeListReservation() {
    }

    public void createSportsSpaces() {
    }

    @Override
    public void chooseLanguage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Admin{" + "ID=" + ID + '}';
    }

}

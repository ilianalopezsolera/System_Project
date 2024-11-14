package Class;

public class Admin extends Person {

    private String ID;

    public Admin() {
    }

    public Admin(String ID,String name, String IDPerson, String password,
            Contact contact) {
        super(name, IDPerson, password, contact);
        this.ID = ID;
    }
    
    public void registerSpaces(SportSpace[] listSportSpace, int spaces) {
    
    }

    public void modifySpaces() {
    }

    public void deleteSpaces() {
    }

    public void seeListReservation() {
    }

    @Override
    public void chooseLanguage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Admin " + "ID: " + ID;
    }

}

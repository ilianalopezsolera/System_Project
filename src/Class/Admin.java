package Class;

import java.util.*;

public class Admin extends Person {

    private String ID;

    public Admin() {
    }

    public Admin(String ID, String name, String IDPerson, String password,
            Contact contact) {
        super(name, IDPerson, password, contact);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Admin[] adminList() {
        Admin[] administrators = new Admin[4];
        Contact contact1 = new Contact("meylin.lopez@ucr.ac.cr", 63158845);
        Contact contact2 = new Contact("reychell.acuña@ucr.ac.cr", 62294545);
        Contact contact3 = new Contact("carlos.rodriguez@ucr.ac.cr", 70716232);
        Contact contact4 = new Contact("dilan.gonzales@ucr.ac.cr", 70746222);

        administrators[0] = new Admin("UCR01", "Meylin Lopez", "604720411",
                "hgsfr45", contact1);
        administrators[1] = new Admin("UCR02", "Reychell Acuña", "604450667",
                "ujmki87", contact2);
        administrators[2] = new Admin("UCR03", "Carlos Rodriguez", "600170789",
                "qwert56", contact3);
        administrators[3] = new Admin("UCR04", "Dilan Gonzales", "609870567",
                "yuiop90", contact4);
        return administrators;
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

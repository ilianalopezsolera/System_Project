package Class;

import java.util.Scanner;

public class User extends Person {

    public User() {
    }

    public User(String name, String IDPerson, String carnet, Contact contact) {
        super(name, IDPerson, contact);
    }

    public User(String name, String carnet, Contact contact) {
        super(name, carnet, contact);
    }

    public void makeReservation(SportSpace[] sportSpaces, String spaceName, String file) {
        for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].getName().equals(spaceName)) {  // Verifica el nombre del espacio
                if (sportSpaces[i].getAvailability()) {  // Verifica si el espacio está disponible
                    System.out.println("Espacios disponibles");
                    System.out.println(sportSpaces[i]);
                    //sportSpaces[1].setAvailability(false);
                }
            }
        }
    }

    public void seeAvailableList(SportSpace[] sportSpaces) {
        for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].getAvailability()==true) {
                System.out.println("-------------------------------------------"
                        + "----------------------------------------------------"
                        + "-----");
                System.out.println(sportSpaces[i]);
            }
        }
    }
    
     public void viewHistory(String identifier){
        
    }

    @Override
    public void chooseLanguage() {
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author ilico
 */
public class SportSpace {

    private String name;

    private String type;
    
    private boolean availability = true;
    
    private int spaces = 10;

    public SportSpace() {
    }

    public SportSpace(String name, String type, boolean availability) {
        this.name = name;
        this.type = type;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getAvailability() {
        return availability;
    }
    
    public void setAvailability(boolean availability){
        this.availability = availability;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }
    
    public SportSpace[] fillSportSpace(){
        SportSpace[] sp = new SportSpace[spaces];
        sp[0] = new SportSpace("Baloncesto", "Tipo", true);
        sp[1] = new SportSpace("Futbol", "Tipo", false);
        sp[2] = new SportSpace("Gimnasio", "Tipo", true);
        sp[3] = new SportSpace("Baloncesto", "Tipo", true);
        sp[4] = new SportSpace("Futbol", "Tipo", false);
        sp[5] = new SportSpace("Gimnasio", "Tipo", true);
        sp[6] = new SportSpace("Baloncesto", "Tipo", true);
        sp[7] = new SportSpace("Futbol", "Tipo", false);
        sp[8] = new SportSpace("Gimnasio", "Tipo", true);
        sp[9] = new SportSpace("Gimnasio", "Tipo", true);
        return sp;
    }
    
    public void showAvailability(SportSpace[] sportSpaces) {
        for (int i = 0; i < sportSpaces.length; i++) {
                if (sportSpaces[i].availability = true) {  // Verifica si el espacio está disponible
                    System.out.println(sportSpaces[i]);
                }
        }
    }
    
    public boolean seeAvailability(SportSpace[] sportSpaces, String spaceName){
          for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].getName().equals(spaceName)) {  // Verifica el nombre del espacio
                if (sportSpaces[i].availability) {  // Verifica si el espacio está disponible
                    System.out.println("El espacio " + spaceName + " se encuentra disponible.");
                    return true;  // Retorna true si la reserva fue exitosa
                } else {
                    System.out.println("El espacio ya está reservado.");
                    return false;  // Retorna false si el espacio ya está reservado
                }
            }
        }
        System.out.println("Espacio no encontrado.");
        return false;  // Retorna false si el espacio no existe en el arreglo
    }

    @Override
    public String toString() {
        return "SportSpace{" + "name=" + name + ", type=" + type + ""
                + ", availability=" + availability + ", spaces=" + spaces + '}';
    }
    
}

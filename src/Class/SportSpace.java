/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author ilico
 */
public class SportSpace {

    private String name;

    private String type;

    private boolean availability;

    private String date;

    private String time;

    public SportSpace() {
    }

    public SportSpace(String name, String type, boolean availability, String date, String time) {
        this.name = name;
        this.type = type;
        this.availability = availability;
        this.date = date;
        this.time = time;
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

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public SportSpace[] fillSporSpaces(){
                SportSpace[] sportSpaces = new SportSpace[156]; // Arreglo con el tamaño necesario
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Calendario reservas.txt"))) {
            String line;

            while ((line = br.readLine()) != null && index < sportSpaces.length) {
                String[] parts = line.split(", ");

                // Extraer y procesar los datos
                String name = parts[0].split(": ")[1];
                String type = parts[1].split(": ")[1];
                boolean availability = Boolean.parseBoolean(parts[2].split(": ")[1]);
                String date = parts[3].split(": ")[1];
                String time = parts[4].split(": ")[1];

                // Crear el objeto SportSpace y agregarlo al arreglo
                sportSpaces[index++] = new SportSpace(name, type, availability, date, time);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sportSpaces;
    }

    public void showAvailability(SportSpace[] sportSpaces) {
        for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].availability = true) {  // Verifica si el espacio está disponible
                System.out.println(sportSpaces[i]);
            }
        }
    }

  public boolean seeAvailability(SportSpace[] sportSpaces, String spaceName) {
    boolean found = false;  // Variable para registrar si encuentra espacios disponibles
    
    for (int i = 0; i < sportSpaces.length; i++) {
        if (sportSpaces[i].getName().trim().equalsIgnoreCase(spaceName)) {  // Verifica el nombre del espacio
            if (sportSpaces[i].availability) {  // Verifica si el espacio está disponible
                System.out.println("-------------------------------------------"
                        + "----------------------------------------------------"
                        + "-----");
                System.out.println(sportSpaces[i]);
                found = true;  // Marca que encontró al menos un espacio disponible
            }
        }
    }
    
    if (!found) {
        System.out.println("No hay espacios disponibles con el nombre '" + spaceName + "'.");
    }
    
    return found;
}


    @Override
    public String toString() {
        return "sport space name: " + name + ", type: " + type + ", availability: " 
                + availability + ", date: " + date + ", time: " + time;
    }

}

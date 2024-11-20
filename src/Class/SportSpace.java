/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 * Represents a sport space with details such as name, type, availability, 
 * date, and time. The class provides methods to check and display the 
 * availability of sport spaces.
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
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

    /**
     * Displays the available sport spaces from the provided list of sport spaces.
     * This method checks the availability status of each space and prints the 
     * details of those that are available.
     * 
     * <p>The method iterates through the array of `SportSpace` objects, 
     * and for each space with an availability status set to true, it prints the
     * information of that space to the console.</p>
     * 
     * @param sportSpaces An array of `SportSpace` objects representing the 
     * available sport spaces to be checked. 
     */
    public void showAvailability(SportSpace[] sportSpaces) {
        for (int i = 0; i < sportSpaces.length; i++) {
            if (sportSpaces[i].availability = true) {  // Verifica si el espacio está disponible
                System.out.println(sportSpaces[i]);
            }
        }
    }

    /**
     * Checks the availability of a specific sport space by its name and displays
     * the available reservation details.
     * 
     * <p>This method searches for a given sport space in the reservation 
     * calendar file. If the space is available (indicated by the status "true"),
     * the method prints the corresponding reservation details to the 
     * console.</p>
     * 
     * @param spaceName The name of the sport space to check availability for.
     * @param language  The language code to load the appropriate messages 
     * for the user.
     * @return A boolean value indicating whether the requested space is 
     * available. Returns true if the space is available, and false if no 
     * available spaces are found.
     */
    public boolean seeAvailability(String spaceName, String language) {
        boolean found = false;  // Variable para registrar si encuentra espacios disponibles
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        System.out.println(messages.getString("availabilitySpaces"));

        try (BufferedReader reader = new BufferedReader(new FileReader("Calendario reservas.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(spaceName) && line.contains("true")) {
                    System.out.println(line);
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println(messages.getString("errorReaderFile"));
            e.printStackTrace();
        }

        return found;
    }

    @Override
    public String toString() {
        return "sport space name: " + name + ", type: " + type + ", availability: "
                + availability + ", date: " + date + ", time: " + time;
    }

}

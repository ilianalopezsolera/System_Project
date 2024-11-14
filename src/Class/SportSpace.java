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

    public SportSpace[] fillSportSpaces() {
        SportSpace[] sportSpaces = new SportSpace[156]; // Ajusta el tamaño según la cantidad de registros en el archivo
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Calendario reservas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Omite la primera línea del archivo si es un encabezado
                if (linea.startsWith("Nombre:1"
                        + "")) {
                    continue;
                }

                // Parseo de la línea
                String[] partes = linea.split(", ");
                String nombre = partes[0].split(": ")[1].trim();
                String tipo = partes[1].split(": ")[1].trim();
                boolean disponibilidad = Boolean.parseBoolean(partes[2].split(": ")[1]);
                String fecha = partes[3].split(": ")[1].trim();
                String hora = partes[4].split(": ")[1].trim();

                // Crear y agregar el objeto SportSpace al arreglo
                sportSpaces[index++] = new SportSpace(nombre, tipo, disponibilidad, fecha, hora);
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
                System.out.println("----------------------------------------------------------------------------------------------------");
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
        return "SportSpace{" + "name=" + name + ", type=" + type + ", availability=" + availability + ", date=" + date + ", time=" + time + '}';
    }

}

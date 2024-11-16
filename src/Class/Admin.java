package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void registerSpaces() {
        int numberSpaces;
        try {
            FileWriter fw = new FileWriter("Calendario reservas.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Registrar espacio");
            System.out.print("Digite la cantidad de espacios a registrar: ");
            numberSpaces = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberSpaces; i++) {
                System.out.println("Registro " + (i + 1) + ":");
                System.out.print("Nombre del espacio deportivo: ");
                String name = scanner.nextLine();

                System.out.print("Tipo: ");
                String type = scanner.next();
                scanner.nextLine();

                System.out.print("Fecha: ");
                String date = scanner.next();
                scanner.nextLine();

                System.out.print("Hora: ");
                String time = scanner.next();
                scanner.nextLine();

                bw.newLine();
                bw.write("Nombre: " + name + ", tipo: " + type + ", disponibilidad: "
                        + true + ", fecha: " + date + ", hora: " + time);
            }

            bw.close();
            System.out.println("Datos guardados en calendario de reservas");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el fichero: "
                    + e.getMessage());
        }
    }

    public void modifySpaces() {
    }

    public void deleteSpaces() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite los datos del espacio a eliminar");
        System.out.print("Nombre: ");
        String nameSpace = scanner.nextLine();

        System.out.print("Fecha: ");
        String date = scanner.next();
        scanner.nextLine();

        System.out.print("Hora: ");
        String time = scanner.next();
        scanner.nextLine();

        File inputFile = new File("Calendario reservas.txt");
        File tempFile = new File("tempFile.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                // Si la línea contiene todas las palabras dadas, no la 
                //escribimos en el archivo temporal
                if (line.contains(nameSpace) && line.contains(date)
                        && line.contains(time)) {
                    continue; // Salta la línea
                }
                // Escribimos la línea en el archivo temporal
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar el archivo.");
            e.printStackTrace();
            return;
        }

        // Reemplazar el archivo original con el archivo temporal
        if (inputFile.delete()) {
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error al renombrar el archivo temporal.");
            } else {
                System.out.println("Espacio eliminado correctamente.");
            }
        } else {
            System.out.println("Error al eliminar el archivo original.");
        }
    }

    public void seeListReservation() {
        try {
            FileReader reader = new FileReader ("Historial sistema de reservas.txt");
            BufferedReader br = new BufferedReader(reader);
            
            String line;
            
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }
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

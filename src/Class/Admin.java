package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ResourceBundle;
import java.util.Locale;

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

    public void registerSpaces(String language) {
        int numberSpaces;
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Calendario reservas.txt", true))) {

            Scanner scanner = new Scanner(System.in);

            System.out.println(messages.getString("numRegisterSpaces"));
            numberSpaces = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberSpaces; i++) {
                System.out.print(messages.getString("register") + (i+1) + ":");

                System.out.println(messages.getString("spaceNamePrompt"));
                String name = scanner.nextLine();

                System.out.println(messages.getString("typeSpace"));
                String type = scanner.next();
                scanner.nextLine();

                System.out.println(messages.getString("datePromp"));
                String date = scanner.next();
                scanner.nextLine();

                System.out.println(messages.getString("timePrompt"));
                String time = scanner.next();
                scanner.nextLine();

                writer.write("Nombre: " + name + ", tipo: " + type + ", disponibilidad: "
                        + true + ", fecha: " + date + ", hora: " + time);
                writer.newLine();
            }
            System.out.println(messages.getString("safeData"));
        } catch (IOException e) {
            System.out.println(messages.getString("erroWriterFile"));
            e.printStackTrace();
        }
    }

    public void modifySpaces() {
    }

    public void deleteSpaces(String language) {
        int numberSpaces = 0;
        Scanner scanner = new Scanner(System.in);

        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        File inputFile = new File("Calendario reservas.txt");
        File tempFile = new File("tempFile.txt");

        System.out.println(messages.getString("numDeleteSpaces"));
        numberSpaces = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberSpaces; i++) {
            System.out.print(messages.getString("deleteSpace") + (i+1));
            System.out.println(messages.getString("dataSpaceDelete"));
            System.out.println(messages.getString("namePrompt"));
            String nameSpace = scanner.nextLine();

            System.out.println(messages.getString("datePrompt"));
            String date = scanner.next();
            scanner.nextLine();

            System.out.println(messages.getString("timePrompt"));
            String time = scanner.next();
            scanner.nextLine();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

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
                System.out.println(messages.getString("errorProcessFile"));
                e.printStackTrace();
            }

            // Reemplazar el archivo original con el archivo temporal
            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println(messages.getString("errorREnamingTempFile"));
                } else {
                    System.out.println(messages.getString("correctSpaceDelete"));
                }
            } else {
                System.out.println(messages.getString("errorDeleteInputFile"));
            }
        }
    }

    public void seeListReservation(String language) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        try {
            FileReader reader = new FileReader("Historial sistema de reservas.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(messages.getString("errorReaderFile"));
            e.printStackTrace();
        }
    }

    public void seeSportSpaces(String language) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Calendario reservas.txt"))) {
            String line;

            System.out.println(messages.getString("calendarReservations"));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(messages.getString("errorReaderFile"));
            e.printStackTrace();
        }
    }

    @Override
    public String chooseLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un idioma / Select a language / Sélectionnez une langue:");
        System.out.println("1. Español \n2. Français \n3. Italiano");
        int languageOption = scanner.nextInt();
        scanner.nextLine();
        
        String language = switch (languageOption) {
            case 1 ->
                "es"; // Español
            case 2 ->
                "fr"; // Francés
            case 3 ->
                "it"; // Italiano
            default ->
                "es"; // Por defecto, español
        };
        return language;
    }

    @Override
    public String toString() {
        return "Admin " + "ID: " + ID;
    }

}

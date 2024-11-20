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

/**
 * Represents an administrator in the system.
 * 
 * <p>The Admin class extends from Person and contains the administrator's 
 * information such as ID, and provides methods for registering, deleting, 
 * and viewing sports spaces and reservations.</p>
 */
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

    /**
     * Creates and returns an array of objects of type Admin, which represents a
     * list of administrators with their respective data.
     * 
     * @return  an array of 4 Admin objects.
     */
    public Admin[] adminList() {
        Admin[] administrators = new Admin[4];
        Contact contact1 = new Contact("meylin.lopez@ucr.ac.cr", 63158845);
        Contact contact2 = new Contact("reychell.acuña@ucr.ac.cr", 62294545);
        Contact contact3 = new Contact("carlos.rodriguez@ucr.ac.cr", 70716232);
        Contact contact4 = new Contact("dilan.gonzales@ucr.ac.cr", 70746222);

        administrators[0] = new Admin("UCR01", "Meylin Lopez", "604720411",
                "meii", contact1);
        administrators[1] = new Admin("UCR02", "Reychell Acuña", "604450667",
                "123", contact2);
        administrators[2] = new Admin("UCR03", "Carlos Rodriguez", "600170789",
                "qwert56", contact3);
        administrators[3] = new Admin("UCR04", "Dilan Gonzales", "609870567",
                "321", contact4);
        return administrators;
    }

    /**
     * Registers information about sports spaces and saves it to a file.
     * 
     * <p>This method prompts the user to input details about a number of sports
     * spaces (e.g., name, type, date, and time) and writes this information 
     * into a file named "Calendario reservas.txt". It uses a ResourceBundle to
     * display messages in the specified language.</p>
     * 
     * @param language the language code for the messages 
     */
    public void registerSpaces(String language) {
        int numberSpaces;
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Calendario reservas.txt", true))) {

            Scanner scanner = new Scanner(System.in);
            
            System.out.println();
            System.out.print(messages.getString("numRegisterSpace"));
            numberSpaces = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberSpaces; i++) {
                System.out.println(messages.getString("register") + (i+1) + ":");

                System.out.print(messages.getString("spaceNamePrompt"));
                String name = scanner.nextLine();

                System.out.print(messages.getString("typeSpace"));
                String type = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("datePrompt"));
                String date = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("timePrompt"));
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

    /**
     * Deletes specific sports spaces from the reservations file.
     * 
     * <p>This method allows the user to remove records of sports spaces stored 
     * in "Calendario reservas.txt" based on the space's name, date, and time.
     * It uses a temporary file to store all records except the ones matching 
     * the criteria, then replaces the original file with the filtered data.</p>
     * 
     * @param language the language code for the messages displayed to the user 
     */
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

    /**
     * Displays the list of reservations stored in the system's history file.
     * 
     * <p>This method reads the content of the 
     * file "Historial sistema de reservas.txt" line by line and prints it to
     * the console.It uses a ResourceBundle to handle messages in the specified 
     * language.</p>
     * 
     * @param language the language code for displaying messages. 
     */
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

    /**
     * Displays the list of registered sports spaces from the reservations file.
     * 
     * <p>This method reads the content of the file "Calendario reservas.txt" 
     * line by line and prints it to the console. It uses a ResourceBundle to 
     * handle messages in the specified language, including a header introducing
     * the list and an error message in case of file issues.</p>
     * 
     * @param language the language code for displaying messages. 
     */
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

    /**
     * Prompts the user to select a language for the system.
     * 
     * <p>This method displays a menu with three language options: Español 
     * (Spanish), Français (French), and Italiano (Italian). It returns the 
     * corresponding language code ("es", "fr", or "it"). If the user enters an 
     * invalid option, the default language ("es") is selected.</p>
     * 
     * @return the language code selected by the user 
     * ("es" for Spanish, "fr" for French, "it" for Italian).
     */
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

    /**
     * Returns a string representation of the Admin object.
     * 
     * <p>This method overrides the default toString method to provide a custom 
     * string representation of an Admin object, showing its type and ID.</p>
     * 
     * @return a string representing the Admin object in the format: 
     * "Admin ID: [ID]"
     */
    @Override
    public String toString() {
        return "Admin " + "ID: " + ID;
    }

}

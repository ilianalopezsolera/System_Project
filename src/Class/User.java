package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 * The User class extends Person and represents a user in the system who can
 * interact with the reservation system to view available spaces, check their 
 * reservation history, and delete reservations.
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
public class User extends Person {

    public User() {
    }

    public User(String name, String IDPerson, String carnet, Contact contact) {
        super(name, IDPerson, contact);
    }

    public User(String name, String carnet, Contact contact) {
        super(name, carnet, contact);
    }

    /**
     * Displays a list of available sport spaces from the reservation calendar.
     *
     * <p>
     * This method provides the user with two options to view the available
     * sport spaces. The user can either view all the available spaces or search
     * for a specific space by its name. The method reads from the "Calendario
     * reservas.txt" file to fetch the relevant data.</p>
     *
     * <p>
     * The options are as follows:</p>
     * <ol>
     * <li>Option 1: Display all available sport spaces.</li>
     * <li>Option 2: Search and display available spaces by name.</li>
     * </ol>
     *
     * @param language The language code to load the appropriate messages for
     * the user.
     */
    public void seeAvailableList(String language) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        System.out.println(messages.getString("seeListSpaces"));
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                try (BufferedReader reader = new BufferedReader(new FileReader("Calendario reservas.txt"))) {

                    String line;

                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println(messages.getString("errorReaderFile"));
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print(messages.getString("spaceNamePrompt"));
                String nameSpace = scanner.nextLine();

                try (BufferedReader reader = new BufferedReader(new FileReader("Calendario reservas.txt"))) {

                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (line.equalsIgnoreCase(nameSpace)) {
                            System.out.println(line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(messages.getString("errorReaderFile"));
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    /**
     * Displays the reservation history for a user based on their identifier.
     *
     * <p>
     * This method allows the user to view their reservation history by
     * searching through the "Historial sistema de reservas.txt" file. The user
     * can search for their reservations either by carnet (ID) or by a specific
     * identifier depending on the selected option.</p>
     *
     * <p>
     * The options are as follows:</p>
     * <ol>
     * <li>Option 1: Search by carnet (ID) number.</li>
     * <li>Option 2: Search by a user-specific identifier (ID).</li>
     * </ol>
     *
     * @param language The language code to load the appropriate messages for
     * the user.
     */
    public void viewHistory(String language) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        Scanner scanner = new Scanner(System.in);
        boolean found = false;  // Para verificar si encontramos alguna reserv
        String identifier = "";

        System.out.println(messages.getString("reserveAs"));
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print(messages.getString("carnetPrompt"));
                identifier = scanner.next();
                scanner.nextLine();
                break;
            case 2:
                System.out.print(messages.getString("idPrompt"));
                identifier = scanner.next();
                scanner.nextLine();
                break;
            default:
                break;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Historial sistema de reservas.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(identifier)) {
                    System.out.println(line);
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println(messages.getString("errorReaderFile"));
            e.printStackTrace();
        }
        if (!found) {
            System.out.println(messages.getString("noReservationsFound"));
        }
    }

    /**
     * Deletes a reservation based on the user's input and specific identifiers.
     *
     * <p>
     * This method allows a user to delete a reservation from the "Historial
     * sistema de reservas.txt" file. The user can delete reservations by
     * providing specific details such as the carnet, space name, date, and
     * time. The process ensures the original file is updated with the remaining
     * reservations by creating a temporary file, omitting the targeted
     * reservation, and replacing the original file.</p>
     *
     * <p>
     * The user has the following options:</p>
     * <ol>
     * <li>Option 1: Delete a reservation by searching with the carnet
     * (ID).</li>
     * <li>Option 2: Delete a reservation using a user-specific identifier
     * (ID).</li>
     * <li>Option 3: Exit without making any changes.</li>
     * </ol>
     *
     * <p>
     * During the process, the system checks each line in the reservation
     * history file. If a line matches the provided details, it is excluded from
     * the updated file. If any errors occur during file operations, appropriate
     * error messages are displayed.</p>
     *
     * @param language The language code to load localized messages for user
     * interaction. Examples: "en" for English, "es" for Spanish.
     */
    public void deleteReservation(String language) {
        Scanner scanner = new Scanner(System.in);
        String carnet;
        String date;
        String IDPerson;
        String time;
        String nameSpace;
        File inputFile = new File("Historial sistema de reservas.txt");
        File tempFile = new File("tempFile.txt");
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        System.out.println(messages.getString("reserveAs"));
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println(messages.getString("enterData"));
                System.out.print(messages.getString("carnetPrompt"));
                carnet = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("spaceNamePrompt"));
                nameSpace = scanner.nextLine();

                System.out.print(messages.getString("datePrompt"));
                date = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("timePrompt"));
                time = scanner.next();
                scanner.nextLine();

                try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        // Si la línea contiene todas las palabras dadas, no la 
                        //escribimos en el archivo temporal
                        if (line.contains(carnet) && line.contains(nameSpace)
                                && line.contains(date) && line.contains(time)) {
                            continue; // Salta la línea
                        }
                        // Escribimos la línea en el archivo temporal
                        bw.write(line);
                        bw.newLine();
                    }

                } catch (IOException e) {
                    System.out.println(messages.getString("errorProcessFile"));
                    e.printStackTrace();
                    return;
                }

                // Reemplazar el archivo original con el archivo temporal
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.out.println(messages.getString("errorRenamingTempFile"));
                    } else {
                        System.out.println(messages.getString("correctReservationDelete"));
                    }
                } else {
                    System.out.println(messages.getString("errorDeleteInputFile"));
                }
                break;
            case 2:
                System.out.println(messages.getString("enterData"));
                System.out.print(messages.getString("carnetPrompt"));
                IDPerson = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("spaceNamePrompt"));
                nameSpace = scanner.nextLine();

                System.out.print(messages.getString("datePrompt"));
                date = scanner.next();
                scanner.nextLine();

                System.out.print(messages.getString("timePrompt"));
                time = scanner.next();
                scanner.nextLine();

                try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        // Si la línea contiene todas las palabras dadas, no la 
                        //escribimos en el archivo temporal
                        if (line.contains(IDPerson) && line.contains(nameSpace)
                                && line.contains(date) && line.contains(time)) {
                            continue; // Salta la línea
                        }
                        // Escribimos la línea en el archivo temporal
                        bw.write(line);
                        bw.newLine();
                    }

                } catch (IOException e) {
                    System.out.println(messages.getString("errorProcessFile"));
                    e.printStackTrace();
                    return;
                }

                // Reemplazar el archivo original con el archivo temporal
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.out.println(messages.getString("errorRenamingTempFile"));
                    } else {
                        System.out.println(messages.getString("correctReservationDelete"));
                    }
                } else {
                    System.out.println(messages.getString("errorDeleteInputFile"));
                }
                break;
            case 3:
                break;
            default:

                break;
        }
    }

    /**
     * Prompts the user to select a language for the system.
     *
     * <p>
     * This method displays a menu with three language options: Español
     * (Spanish), Français (French), and Italiano (Italian). It returns the
     * corresponding language code ("es", "fr", or "it"). If the user enters an
     * invalid option, the default language ("es") is selected.</p>
     *
     * @return the language code selected by the user ("es" for Spanish, "fr"
     * for French, "it" for Italian).
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
}

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

public class User extends Person {

    public User() {
    }

    public User(String name, String IDPerson, String carnet, Contact contact) {
        super(name, IDPerson, contact);
    }

    public User(String name, String carnet, Contact contact) {
        super(name, carnet, contact);
    }

    public void seeAvailableList(String language) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));

        System.out.println(messages.getString("seeListSpaces"));
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                try(BufferedReader reader = new BufferedReader
                (new FileReader("Calendario reservas.txt"))) {

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

                try(BufferedReader reader = new BufferedReader
                (new FileReader("Calendario reservas.txt"))) {

                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (line.contains(nameSpace)) {
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

    public void viewHistory(String language) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        Scanner scanner = new Scanner(System.in);
        boolean found = false;  // Para verificar si encontramos alguna reserv
        String identifier = "";
        
        System.out.println(messages.getString("reserveAs"));
        int option = scanner.nextInt();
        scanner.nextLine();
        
        switch(option){
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
        
        try(BufferedReader reader = new BufferedReader
        (new FileReader("Historial sistema de reservas.txt"))) {

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

                try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

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

                try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

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

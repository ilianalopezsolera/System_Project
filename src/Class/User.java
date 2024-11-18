package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void seeAvailableList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Ver toda la lista. \n2. Ver espacio especifico.");
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
                    System.out.println("Error al leer el archivo.");
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("Nombre del espacio deportivo: ");
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
                    System.out.println("Error al leer el archivo.");
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    public void viewHistory() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;  // Para verificar si encontramos alguna reserv
        String identifier = "";
        
        System.out.println("1. Estudiante. \n2. Personal.");
        int option = scanner.nextInt();
        scanner.nextLine();
        
        switch(option){
            case 1:
                System.out.print("Digite su carnet: ");
                identifier = scanner.next();
                scanner.nextLine();
                break;
            case 2:
                System.out.print("Digite su cedula: ");
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
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        if (!found) {
            System.out.println("No se encontraron reservas para el carnet: " + identifier);
        }
    }

    public void deleteReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Usuario estudiante. \n2. Usuario personal. "
                + "\n3. salir.");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Digite los datos");
                System.out.print("Carnet: ");
                String carnet = scanner.next();
                scanner.nextLine();

                System.out.print("Nombre del espacio deportivo: ");
                String nameSpace = scanner.nextLine();

                System.out.print("Fecha: ");
                String date = scanner.next();
                scanner.nextLine();

                System.out.print("Hora: ");
                String time = scanner.next();
                scanner.nextLine();
                
                File inputFile = new File("Historial sistema de reservas.txt");
                File tempFile = new File("tempFile.txt");

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
                    System.out.println("Error al procesar el archivo.");
                    e.printStackTrace();
                    return;
                }

                // Reemplazar el archivo original con el archivo temporal
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        System.out.println("Error al renombrar el archivo temporal.");
                    } else {
                        System.out.println("Reserva eliminada correctamente.");
                    }
                } else {
                    System.out.println("Error al eliminar el archivo original.");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    @Override
    public void chooseLanguage() {
    }
}

package Class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author ilico
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Admin administrator = new Admin();
        SportSpace sportSpace = new SportSpace();
        SportSpace[] listSpaces = sportSpace.fillSportSpaces();

        int option;
        Scanner scanner = new Scanner(System.in);

        String name;
        String carnet;
        long number;
        String correo;
        String IDPerson = "";
        String spaceName;
        String dateReservation;
        String timeReservation;

//        try{
//            //abre el archivo Historial sistema de reservas.txt
//            FileWriter historyFile = new FileWriter("Historial sistema de reservas.txt");
//        } catch (IOException e){
//            System.out.println("Error al leer el archivo.");
//            e.printStackTrace();
//        }
        
        System.out.println("----- SISTEMA DE ESPACIOS DEPORTIVOS -----");
        System.out.println("LENGUAJE");
        System.out.println("1. Español. 2. English.");
        option = scanner.nextInt();
        
        switch (option) {
            case 1:
                System.out.println("----- TIPO DE USUARIO -----");
                System.out.println("1. Usuario. \n2. Administrador");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("MENU OPCIONES");
                        System.out.println("1. Hacer reserva. "
                                + "\n2. Eliminar reserva. "
                                + "\n3. Ver historial. \n4. Ver espacios deportivos disponibles. \n5. Salir");
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("----- TIPO DE USUARIO -----");
                                System.out.println("1. Estudiante. "
                                        + "\n2. Personal.");
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    case 1:
                                        System.out.println("----- ESTUDIANTE UCR ------");
                                        System.out.print("Digite el nombre "
                                                + "del espacio a reservar: ");
                                        spaceName = scanner.nextLine().trim();
                                        if (sportSpace.seeAvailability(listSpaces, spaceName) == true) {
                                            System.out.println("¿Desea continuar con la reserva?");
                                            System.out.println("1. SI. \n2. NO.");
                                            option = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (option) {
                                                case 1:
                                                    System.out.println("Seccion datos personales");
                                                    // Pedir al usuario que ingrese los datos
                                                    System.out.print("Nombre: ");
                                                    name = scanner.nextLine();

                                                    System.out.print("Carnet: ");
                                                    carnet = scanner.next();

                                                    System.out.print("Numero de telefono: ");
                                                    number = scanner.nextInt();

                                                    System.out.print("Direccion de correo: ");
                                                    correo = scanner.next();
                                                    
                                                    System.out.println("Escoja una fecha y hora");
                                                    System.out.print("Fecha: ");
                                                    dateReservation = scanner.next();
                                                    System.out.print("Hora: ");
                                                    timeReservation = scanner.next();
                                                    
                                                    Contact contact = new Contact(correo, number);
                                                    User userEstudent = new User(name, carnet, contact);
                                                    Reservation reservationStudent = new Reservation(dateReservation, timeReservation, spaceName, true, userEstudent);
                                                    reservationStudent.createReservation(reservationStudent);
                                                    break;

                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("----- USUARIO PERSONAL UCR -----");
                                        System.out.print("Digite el nombre "
                                                + "del espacio a reservar: ");
                                        spaceName = scanner.next();
                                        if (sportSpace.seeAvailability(listSpaces, spaceName) == true) {
                                            System.out.println("1. Confirmar reserva. \n2. Salir.");
                                            option = scanner.nextInt();
                                            switch (option) {
                                                case 1:
                                                    System.out.println("Seccion datos personales");
                                                    // Pedir al usuario que ingrese los datos
                                                    System.out.print("Nombre: ");
                                                    name = scanner.next();

                                                    System.out.print("Cedula: ");
                                                    IDPerson = scanner.next();

                                                    System.out.print("Numero de telefono: ");
                                                    number = scanner.nextInt();

                                                    System.out.print("Direccion de correo: ");
                                                    correo = scanner.next();
                                                    break;
                                            }
                                            break;
                                        }
                                        break;
                                
                                }
                                break;
                            case 2:
                                System.out.println("1. Agregar espacios. "
                                        + "\n2. Modificar espacios. "
                                        + "\n3. Eliminar espacios. \n4. Salir.");
                                option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        administrator.registerSpaces(listSpaces, 156);
                                        break;
                                    case 2:
                                        administrator.modifySpaces();
                                        break;
                                    case 3:
                                        administrator.deleteSpaces();
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        break;
                                }
                                break;
                        }
                        break;
                    case 2:
                        break;
                }
            }
        }

    }

package Class;

import java.util.*;

/**
 *
 * @author ilico
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        System.out.println("----- SISTEMA DE ESPACIOS DEPORTIVOS -----");
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
                                + "\n3. Ver historial. \n4. Salir");
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("----- TIPO DE USUARIO -----");
                                System.out.println("1. Estudiante. "
                                        + "\n2. Personal.");
                                option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("----- ESTUDIANTE UCR ------");
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

                                                    System.out.print("Carnet: ");
                                                    carnet = scanner.next();

                                                    System.out.print("Numero de telefono: ");
                                                    number = scanner.nextInt();

                                                    System.out.print("Direccion de correo: ");
                                                    correo = scanner.next();

                                                    Contact contact = new Contact(correo, number);
                                                    User userEstudent = new User(name, IDPerson, carnet, contact);

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

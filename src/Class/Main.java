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
        SportSpace sp = new SportSpace();
        SportSpace[] listSportSpaces = sp.fillSportSpace();

        int option;
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String carnet = scanner.nextLine();
        long number = scanner.nextInt();
        String correo = scanner.nextLine();
        String IDPerson = scanner.nextLine();

        System.out.println("si corre");
        System.out.println("1. Español. \n2. English.");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("1. Usuario. \n2. Administrador");
                switch (option) {
                    case 1:
                        System.out.println("1. Hacer reserva. "
                                + "\n2. Eliminar reserva. "
                                + "\n3. Ver historial. \n4. Salir");
                        switch (option) {
                            case 1:
                                System.out.println("1. Estudiante. "
                                        + "\n2. Personal.");

                                switch (option) {
                                    case 1:
                                        System.out.print("Digite el nombre "
                                                + "del espacio a reservar: ");
                                        String spaceName = scanner.nextLine();
                                        if (sp.seeAvailability(listSportSpaces, spaceName) == true) {
                                            System.out.println("1. Confirmar reserva. \n2. Salir.");
                                            switch (option) {
                                                case 1:
                                                    // Pedir al usuario que ingrese los datos
                                                    System.out.print("Nombre: ");
                                                    name = scanner.nextLine();
                                                    
                                                    System.out.print("Carnet: ");
                                                    carnet = scanner.nextLine();

                                                    System.out.print("Numero de telefono: ");
                                                    number = scanner.nextInt();

                                                    System.out.print("Direccion de correo: ");
                                                    correo = scanner.nextLine();

                                                    Contact contact = new Contact(correo, number);
                                                    User userEstudent = new User(name,IDPerson,carnet, contact);
                                                    
                                                    break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        // Pedir al usuario que ingrese los datos
                                        System.out.print("Nombre: ");
                                        name = scanner.nextLine();

                                        System.out.print("Cedula: ");
                                        IDPerson = scanner.nextLine();

                                        System.out.print("Numero de telefono: ");
                                        number = scanner.nextInt();

                                        System.out.print("Direccion de correo: ");
                                        correo = scanner.nextLine();
                                        break;
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1. Agregar espacios. "
                                + "\n2. Modificar espacios. "
                                + "\n3. Eliminar espacios. \n4. Salir.");
                        switch (option) {
                            case 1:
                                administrator.registerSpaces(listSportSpaces, 10);
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

package Class;

import java.io.File;
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
        Admin[] adminList = administrator.adminList();

        ReservationSystem reservationSystem = new ReservationSystem();
        Reservation reservation = new Reservation();
        SportSpace sportSpace = new SportSpace();
        User user = new User();

        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- SISTEMA DE ESPACIOS DEPORTIVOS -----");
        System.out.println("LENGUAJE");
        System.out.println("1. Español. 2. Frances. 3. Portugues. 4. Salir.");
        option = scanner.nextInt();

        //MENU
        switch (option) {
            //idiomas
            //Español
            case 1:
                System.out.println("---- TIPO DE INGRESO ----");
                System.out.println("1. Usuario. \n2. Administrador. \n3. Salir");
                option = scanner.nextInt();
                switch (option) {
                    //Usuario
                    case 1:
                        System.out.println("----- OPCIONES USUARIO -----");
                        System.out.println("1. Hacer reserva. "
                                + "\n2. Eliminar reserva. "
                                + "\n3. Ver historial. \n4. Ver espacios "
                                + "deportivos disponibles. \n5. Salir");
                        option = scanner.nextInt();
                        switch (option) {
                            //Reservar
                            case 1:
                                reservation.createReservation(sportSpace);
                                break;
                            //Eliminar reserva
                            case 2:
                                user.deleteReservation();
                                break;
                            //Ver historial
                            case 3:
                                user.viewHistory();
                                break;
                            //Ver espacios disponibles
                            case 4:
                                user.seeAvailableList();
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    //Administrador
                    case 2:
                        if (reservationSystem.verifyPassword(adminList)) {
                            System.out.println("----- OPCIONES ADMINISTRADOR -----");
                            System.out.println("1. Registrar espacio. "
                                    + "\n2. Modificar espacio. "
                                    + "\n3. Eliminar espacio. \n4. Ver reservas."
                                    + "\n5. Ver espacios deportivos. \n6. Salir.");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                //Registrar
                                case 1:
                                    administrator.registerSpaces();
                                    break;
                                //Modificar
                                case 2:
                                    administrator.modifySpaces();
                                    break;
                                //Eliminar
                                case 3:
                                    administrator.deleteSpaces();
                                    break;
                                //Ver reservas
                                case 4:
                                    administrator.seeListReservation();
                                    break;
                                //Ver espacios deportivos
                                case 5:
                                    administrator.seeSportSpaces();
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    //Salida
                    case 3:
                        break;
                    default:
                        break;
                }
                break;
            //Frances
            case 2:
                System.out.println("---- TYPE DE REVENU ----");
                System.out.println("1. Utilisateur. \n2. Administrateur. \n3. Sors.");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("----- OPTIONS DE L’UTILISATEUR -----");
                        System.out.println("1. Faites une réservation. "
                                + "\n2. Supprimer la réservation. "
                                + "\n3. Voir l’histoire. \n4. Voir les espaces "
                                + "sportifs disponibles. \n5. Congé");
                        option = scanner.nextInt();
                        scanner.nextLine();
                        switch (option) {
                            //Reservar
                            case 1:
                                reservation.createReservation(sportSpace);
                                break;
                            //Eliminar reserva
                            case 2:
                                user.deleteReservation();
                                break;
                            //Ver historial
                            case 3:
                                user.viewHistory();
                                break;
                            //Ver espacios disponibles
                            case 4:
                                user.seeAvailableList();
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        if (reservationSystem.verifyPassword(adminList)) {
                            System.out.println("----- ADMINISTRATEUR -----");
                            System.out.println("1. Espace d’enregistrement. "
                                    + "\n2. Modifier l’espace. "
                                    + "\n3. Supprimer l’espace. \n4. Voir les réservations. "
                                    + "\n5. Voir les sites sportifs."
                                    + "\n6. Congé ");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                //Registrar
                                case 1:
                                    administrator.registerSpaces();
                                    break;
                                //Modificar
                                case 2:
                                    administrator.modifySpaces();
                                    break;
                                //Eliminar
                                case 3:
                                    administrator.deleteSpaces();
                                    break;
                                //Ver reservas
                                case 4:
                                    administrator.seeListReservation();
                                    break;
                                //Ver espacios deportivos
                                case 5:
                                    administrator.seeSportSpaces();
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
                break;
            //Portugues
            case 3:
                System.out.println("---- TIPO DE RENDA ----");
                System.out.println("1. Usuário. \n2. Administrador. \n3. Sair.");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("----- OPÇÕES DO USUÁRIO -----");
                        System.out.println("1. Faça uma reserva. "
                                + "\n2. Excluir reserva. "
                                + "\n3. Veja a história. \n4. Ver espaços "
                                + " esportes disponíveis. \n5. Sair");
                        option = scanner.nextInt();
                        switch (option) {
                            //Reservar
                            case 1:
                                reservation.createReservation(sportSpace);
                                break;
                            //Eliminar reserva
                            case 2:
                                user.deleteReservation();
                                break;
                            //Ver historial
                            case 3:
                                user.viewHistory();
                                break;
                            //Ver espacios disponibles
                            case 4:
                                user.seeAvailableList();
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        if (reservationSystem.verifyPassword(adminList)) {
                            System.out.println("----- ADMINISTRADOR -----");
                            System.out.println("1. Registre o espaço. "
                                    + "\n2. Modifique o espaço. "
                                    + "\n3. Exclua o espaço. \n4. Consulte as reservas."
                                    + "\n5. Ver instalações esportivas. "
                                    + "\n6. Sair");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                //Registrar
                                case 1:
                                    administrator.registerSpaces();
                                    break;
                                //Modificar
                                case 2:
                                    administrator.modifySpaces();
                                    break;
                                //Eliminar
                                case 3:
                                    administrator.deleteSpaces();
                                    break;
                                //Ver reservas
                                case 4:
                                    administrator.seeListReservation();
                                    break;
                                //Ver espacios deportivos
                                case 5:
                                    administrator.seeSportSpaces();
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
                break;
            //Salida
            case 4:
                break;
            default:
                break;
        }
    }
}

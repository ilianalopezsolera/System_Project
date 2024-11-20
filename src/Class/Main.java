package Class;

import java.util.*;
import java.util.ResourceBundle;
import java.util.Locale;

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
        Admin[] adminList = administrator.adminList();

        ReservationSystem reservationSystem = new ReservationSystem();
        Reservation reservation = new Reservation();
        SportSpace sportSpace = new SportSpace();
        User user = new User();
        RedSocial socialNetwork = new RedSocial();

        int option;
        int income;
        boolean openSystem = true;
        Scanner scanner = new Scanner(System.in);
        String language;
        ResourceBundle messages;

        System.out.println("1. Usuario.\n2. Administrador.\n3. Salir.");
        income = scanner.nextInt();
        scanner.nextLine();

        switch (income) {
            //Usuario
            case 1:
                language = administrator.chooseLanguage();
                messages = ResourceBundle.getBundle("messages", new Locale(language));

                System.out.println();
                System.out.println(messages.getString("system"));
                System.out.println();

                while (openSystem == true) {
                    System.out.println(messages.getString("optionsUser"));
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        //Reservar
                        case 1:
                            reservation.createReservation(sportSpace, language);
                            if (reservation.createReservation(sportSpace, language)) {
                                socialNetwork.shareLink();
                            }
                            break;
                        //Eliminar reserva
                        case 2:
                            System.out.println();
                            user.deleteReservation(language);
                            break;
                        //Ver historial
                        case 3:
                            System.out.println();
                            user.viewHistory(language);
                            break;
                        //Ver espacios disponibles
                        case 4:
                            System.out.println();
                            user.seeAvailableList(language);
                            break;
                        //Salida
                        case 5:
                            System.out.println();
                            System.out.println(messages.getString("exitSystem"));
                            openSystem = false;
                            break;
                        default:
                            System.out.println();
                            System.out.println(messages.getString("invalidSelecction"));
                            System.out.println();
                            break;
                    }
                }
                break;
            //Administrador
            case 2:
                language = user.chooseLanguage();
                messages = ResourceBundle.getBundle("messages", new Locale(language));

                System.out.println();
                System.out.println(messages.getString("system"));
                System.out.println();

                if (reservationSystem.verifyPassword(adminList, language)) {
                    while (openSystem == true) {
                        System.out.println(messages.getString("optionsAdministrator"));
                        option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option) {
                            //Registrar
                            case 1:
                                administrator.registerSpaces(language);
                                break;
                            //Eliminar
                            case 2:
                                administrator.deleteSpaces(language);
                                break;
                            //Ver reservas
                            case 3:
                                administrator.seeListReservation(language);
                                break;
                            //Ver espacios deportivos
                            case 4:
                                administrator.seeSportSpaces(language);
                                break;
                            //Salida
                            case 5:
                                System.out.println();
                                System.out.println(messages.getString("exitSystem"));
                                openSystem = false;
                                break;
                            default:
                                System.out.println();
                                System.out.println(messages.getString("invalidSelecction"));
                                System.out.println();
                                break;
                        }
                    }
                } else {
                    System.out.println(messages.getString("blockedSystem"));
                    openSystem = false;
                }
                break;
            //Salida
            case 3:
                System.out.println();
                messages = ResourceBundle.getBundle("messages", new Locale("es"));
                System.out.println(messages.getString("exitSystem"));
                break;
            default:
                break;
        }
    }
}

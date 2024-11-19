package Class;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        Admin administrator = new Admin();
        Admin[] adminList = administrator.adminList();

        ReservationSystem reservationSystem = new ReservationSystem();
        Reservation reservation = new Reservation();
        SportSpace sportSpace = new SportSpace();
        User user = new User();
        RedSocial socialNetwork = new RedSocial();

        int option = 0;
        Scanner scanner = new Scanner(System.in);
        String language = "";
        
        System.out.println("1. Usuario.\n2. Administrador.");
        option = scanner.nextInt();
        scanner.nextLine();
        
        switch(option){
            case 1:
                language = administrator.chooseLanguage();
                break;
            case 2:
                language = user.chooseLanguage();
                break;
            default:
                break;
        }

        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        
        System.out.println();
        System.out.println(messages.getString("system"));
        System.out.println();
        
        switch (option) {
            //Usuario
            case 1:
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
                        user.deleteReservation(language);
                        break;
                    //Ver historial
                    case 3:
                        user.viewHistory(language);
                        break;
                    //Ver espacios disponibles
                    case 4:
                        user.seeAvailableList(language);
                        break;
                    //Salida
                    case 5:
                        System.out.println(messages.getString("exitSystem"));
                        break;
                    default:
                        System.out.println(messages.getString("invalidSelecction"));
                        break;
                }
                break;
            //Administrador
            case 2:
                if (reservationSystem.verifyPassword(adminList, language)) {
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
                        case 5:
                            System.out.println(messages.getString("exitSystem"));
                            break;
                        default:
                            System.out.println(messages.getString("invalidSelecction"));
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

    }
}

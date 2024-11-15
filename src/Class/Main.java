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
        Admin[] adminList = administrator.adminList();

        ReservationSystem reservationSystem = new ReservationSystem();
        Reservation reservation = new Reservation();
        Reservation[] reservations = reservation.reservationList();

        SportSpace sportSpace = new SportSpace();
        SportSpace[] listSpaces = sportSpace.fillSporSpaces();

        User user = new User();

        int option = 0;
        Scanner scanner = new Scanner(System.in);

        String name;
        String carnet;
        long number;
        String mail;
        String IDPerson = "";
        String spaceName;
        String dateReservation;
        String timeReservation;
        String password;

        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] == null) {
                i = reservations.length;
            } else {
                System.out.println(reservations[i]);
            }
        }

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
                                System.out.println("----- TIPO DE USUARIO -----");
                                System.out.println("1. Estudiante. \n2. Personal."
                                        + " \n3. Salir");
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    //Tipo estudiante 
                                    case 1:
                                        System.out.println("----- ESTUDIANTE UCR -----");
                                        System.out.print("Digite el nombre "
                                                + "del espacio a reservar: ");
                                        spaceName = scanner.nextLine().trim();
                                        System.out.println();
                                        System.out.println("ESPACIOS DISPONIBLES");
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Seccion datos "
                                                    + "personales");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nombre: ");
                                            name = scanner.nextLine();

                                            System.out.print("Carnet: ");
                                            carnet = scanner.next();

                                            System.out.print("Numero de "
                                                    + "telefono: ");
                                            number = scanner.nextInt();
                                            scanner.nextLine();

                                            System.out.print("Direccion "
                                                    + "de correo: ");
                                            mail = scanner.next();

                                            do {
                                                System.out.println("Escoja "
                                                        + "una fecha y hora");

                                                System.out.print("Fecha: ");
                                                dateReservation = scanner.next();

                                                System.out.print("Hora: ");
                                                timeReservation = scanner.next();

                                                Contact contact = new Contact(mail, number);
                                                User userEstudent = new User(name, carnet, contact);
                                                Reservation reservationStudent
                                                        = new Reservation(dateReservation,
                                                                timeReservation, spaceName,
                                                                true, userEstudent);
                                                if (reservationStudent.createReservation(reservationStudent, listSpaces,
                                                        spaceName, dateReservation,
                                                        timeReservation)) {
                                                    System.out.println("Reservación"
                                                            + " guardada en el historial.");
                                                } else {
                                                    System.out.println("ERROR: "
                                                            + "Espacio no disponible");
                                                }
                                                System.out.println("1. Seguir reservando. 2. Salir.");
                                                option = scanner.nextInt();
                                                scanner.nextLine();
                                            } while (option == 1);
                                        }
                                        break;
                                    //Tipo personal
                                    case 2:
                                        System.out.println("----- USUARIO PERSONAL UCR -----");
                                        System.out.print("Digite el nombre "
                                                + "del espacio a reservar: ");
                                        spaceName = scanner.next();
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Seccion "
                                                    + "datos personales");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nombre: ");
                                            name = scanner.next();

                                            System.out.print("Cedula: ");
                                            IDPerson = scanner.next();

                                            System.out.print("Numero de "
                                                    + "telefono: ");
                                            number = scanner.nextInt();

                                            System.out.print("Direccion "
                                                    + "de correo: ");
                                            mail = scanner.next();

                                            System.out.println("Escoja "
                                                    + "una fecha y hora");

                                            System.out.print("Fecha: ");
                                            dateReservation = scanner.next();

                                            System.out.print("Hora: ");
                                            timeReservation = scanner.next();

                                            Contact contact = new Contact(mail, number);
                                            User userPersonal = new User(name, IDPerson, contact);
                                            Reservation reservationPersonal
                                                    = new Reservation(dateReservation,
                                                            timeReservation, spaceName,
                                                            true, userPersonal);
                                            reservationPersonal.createReservation(reservationPersonal, listSpaces,
                                                    spaceName, dateReservation,
                                                    timeReservation);
                                        }
                                        break;
                                    //Salida
                                    case 3:
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            //Eliminar reserva
                            case 2:
                                System.out.println("Digite los datos para cancelar "
                                        + "la reserva");
                                System.out.println("Fecha: ");
                                dateReservation = scanner.next();
                                scanner.nextLine();
                                System.out.println("Hora: ");
                                timeReservation = scanner.next();
                                scanner.nextLine();
                                System.out.println("Espacio deportivo: ");
                                spaceName = scanner.nextLine();
                                reservation.deleteReservation(reservations, dateReservation, timeReservation, spaceName);
                                break;
                            //Ver historial
                            case 3:
                                System.out.println("----- TIPO DE USUARIO -----");
                                System.out.println("1. Estudiante. \n2. Personal."
                                        + " \n3. Salir");
                                option = scanner.nextInt();
                                scanner.nextLine();
                                switch (option) {
                                    case 1:
                                        System.out.print("Digite su carnet: ");
                                        carnet = scanner.next();
                                        scanner.nextLine();
                                        user.viewHistory(carnet, reservations);
                                        break;
                                    case 2:
                                        System.out.print("Digite su cedula: ");
                                        IDPerson = scanner.next();
                                        scanner.nextLine();
                                        user.viewHistory(IDPerson, reservations);

                                        break;
                                    case 3:
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            //Ver espacios disponibles
                            case 4:
                                user.seeAvailableList(listSpaces);
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
                                    + "\n3. Eliminar espacio. \n4. Ver reservas. \n5. Salir");
                            option = scanner.nextInt();
                            switch (option) {
                                //Registrar
                                case 1:
                                    administrator.registerSpaces();
                                    break;
                                //Modificar
                                case 2:
                                    break;
                                //Eliminar
                                case 3:
                                    break;
                                //Ver reservas
                                case 4:
                                    for (int i = 0; i < reservations.length; i++) {
                                        if (reservations[i] == null) {
                                            i = reservations.length;
                                        } else {
                                            System.out.println(reservations[i]);
                                        }
                                    }
                                    break;
                                //Salida
                                case 5:
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
                switch (option) {
                    case 1:
                        System.out.println("----- OPTIONS DE L’UTILISATEUR -----");
                        System.out.println("1. Faites une réservation. "
                                + "\n2. Supprimer la réservation. "
                                + "\n3. Voir l’histoire. \n4. Voir les espaces "
                                + "sportifs disponibles. \n5. Congé");
                        option = scanner.nextInt();
                        switch (option) {
                            //Reservar
                            case 1:
                                System.out.println("----- TYPE D’UTILISATEUR -----");
                                System.out.println("1. Étudiant. \n2. Personnel."
                                        + " \n3. Congé");
                                option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("----- ÉTUDIANT UCR -----");
                                        System.out.print("Saisissez le nom de l'espace sportif: ");
                                        spaceName = scanner.nextLine().trim();
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Section données personnelles");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nom: ");
                                            name = scanner.nextLine();

                                            System.out.print("Carte: ");
                                            carnet = scanner.next();

                                            System.out.print("téléphone: ");
                                            number = scanner.nextInt();

                                            System.out.print("courrier: ");
                                            mail = scanner.next();

                                            System.out.println("Choisissez"
                                                    + "une date et une heure");
                                            System.out.print("Date: ");
                                            dateReservation = scanner.next();
                                            System.out.print("Heure: ");
                                            timeReservation = scanner.next();

                                            Contact contact = new Contact(mail, number);
                                            User userEstudent = new User(name, carnet, contact);
                                            Reservation reservationStudent
                                                    = new Reservation(dateReservation,
                                                            timeReservation, spaceName,
                                                            true, userEstudent);
                                            reservationStudent.createReservation(reservationStudent, listSpaces,
                                                    spaceName, dateReservation,
                                                    timeReservation);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("----- Pesonnel UCR -----");
                                        System.out.print("aisissez le nom de l'espace"
                                                + " sportif: ");
                                        spaceName = scanner.next();
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Section données"
                                                    + " personnelles");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nom: ");
                                            name = scanner.next();

                                            System.out.print("Id: ");
                                            IDPerson = scanner.next();

                                            System.out.print("téléphone: ");
                                            number = scanner.nextInt();

                                            System.out.print("courrier: ");
                                            mail = scanner.next();

                                            System.out.println("Choisissez"
                                                    + "une date et une heure");

                                            System.out.print("Date: ");
                                            dateReservation = scanner.next();

                                            System.out.print("Heure: ");
                                            timeReservation = scanner.next();

                                            Contact contact = new Contact(mail, number);
                                            User userPersonal = new User(name, IDPerson, contact);
                                            Reservation reservationPersonal
                                                    = new Reservation(dateReservation,
                                                            timeReservation, spaceName,
                                                            true, userPersonal);
                                            reservationPersonal.createReservation(reservationPersonal, listSpaces,
                                                    spaceName, dateReservation,
                                                    timeReservation);
                                        }
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            //Eliminar reserva
                            case 2:
                                break;
                            //Ver historial
                            case 3:
                                break;
                            //Ver espacios disponibles
                            case 4:
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("----- ADMINISTRATEUR -----");
                        System.out.println("1. Espace d’enregistrement. "
                                + "\n2. Modifier l’espace. "
                                + "\n3. Supprimer l’espace. \n4. Voir les réservations. "
                                + "\n5. Congé ");
                        option = scanner.nextInt();
                        switch (option) {
                            //Registrar
                            case 1:
                                break;
                            //Modificar
                            case 2:
                                break;
                            //Eliminar
                            case 3:
                                break;
                            //Ver reservas
                            case 4:
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
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
                                System.out.println("----- TIPO DE USUÁRIO -----");
                                System.out.println("1. Estudante. n2. Pessoal."
                                        + " n3. Sair");
                                option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("----- ESTUDANTE UCR -----");
                                        System.out.print("Nome do espaco desportivo: ");
                                        spaceName = scanner.nextLine().trim();
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Dados pessoais");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nome: ");
                                            name = scanner.nextLine();

                                            System.out.print("Cartao: ");
                                            carnet = scanner.next();

                                            System.out.print("Telefone: ");
                                            number = scanner.nextInt();

                                            System.out.print("Correio: ");
                                            mail = scanner.next();

                                            System.out.println("Escolha data e hora");
                                            System.out.print("Data: ");
                                            dateReservation = scanner.next();
                                            System.out.print("Hora: ");
                                            timeReservation = scanner.next();

                                            Contact contact = new Contact(mail, number);
                                            User userEstudent = new User(name, carnet, contact);
                                            Reservation reservationStudent
                                                    = new Reservation(dateReservation,
                                                            timeReservation, spaceName,
                                                            true, userEstudent);
                                            reservationStudent.createReservation(reservationStudent, listSpaces,
                                                    spaceName, dateReservation,
                                                    timeReservation);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("----- Pessoal UCR -----");
                                        System.out.print("Nome do espaco desportivo: ");
                                        spaceName = scanner.nextLine().trim();
                                        if (sportSpace.seeAvailability(listSpaces,
                                                spaceName) == true) {
                                            System.out.println("Dados pessoais");
                                            // Pedir al usuario que ingrese los datos
                                            System.out.print("Nome: ");
                                            name = scanner.nextLine();

                                            System.out.print("Id: ");
                                            IDPerson = scanner.next();

                                            System.out.print("Telefone: ");
                                            number = scanner.nextInt();

                                            System.out.print("Correio: ");
                                            mail = scanner.next();

                                            System.out.println("Escolha data e hora");
                                            System.out.print("Data: ");
                                            dateReservation = scanner.next();
                                            System.out.print("Hora: ");
                                            timeReservation = scanner.next();

                                            Contact contact = new Contact(mail, number);
                                            User userEstudent = new User(name, IDPerson, contact);
                                            Reservation reservationPersonal
                                                    = new Reservation(dateReservation,
                                                            timeReservation, spaceName,
                                                            true, userEstudent);
                                            reservationPersonal.createReservation(reservationPersonal, listSpaces,
                                                    spaceName, dateReservation,
                                                    timeReservation);
                                        }
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            //Eliminar reserva
                            case 2:
                                break;
                            //Ver historial
                            case 3:
                                break;
                            //Ver espacios disponibles
                            case 4:
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("----- ADMINISTRADOR -----");
                        System.out.println("1. Registre o espaço. "
                                + "\n2. Modifique o espaço. "
                                + "\n3. Exclua o espaço. \n4. Consulte as reservas. "
                                + "\n5. Sair");
                        option = scanner.nextInt();
                        switch (option) {
                            //Registrar
                            case 1:
                                break;
                            //Modificar
                            case 2:
                                break;
                            //Eliminar
                            case 3:
                                break;
                            //Ver reservas
                            case 4:
                                break;
                            //Salida
                            case 5:
                                break;
                            default:
                                break;
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

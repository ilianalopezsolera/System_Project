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
        Scanner sc = new Scanner(System.in);
        
        Admin administrator = new Admin();
        
        User user = new User();
        
        SportSpace sp = new SportSpace();
        
        SportSpace[] listSportSpaces = sp.fillSportSpace();
        
        System.out.println("1. Español. \n2. English.");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                System.out.println("1. Usuario. \n2. Administrador");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("1. Hacer reserva. "
                                + "\n2. Eliminar reserva. "
                                + "\n3. Ver historial. 4. Salir");
                        op = sc.nextInt();
                        switch (op){
                            case 1:
                                user.makeReservation();
                                break;
                            case 2:
                                user.deleteReservation();
                                break;
                            case 3:
                                user.seeAvailableList();
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
                                op = sc.nextInt();
                                switch(op){
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
        System.out.println("---------- MENU ----------");

    }

}

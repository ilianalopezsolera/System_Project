/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        SportSpace[] sp = new SportSpace[3];
        sp[0] = new SportSpace("Baloncesto", "Tipo", 2000);
        sp[1] = new SportSpace("Futbol", "Tipo", 2000);
        sp[2] = new SportSpace("Gimnasio", "Tipo", 2000);

        for (SportSpace SportSpace : sp) {
            SportSpace.llenarArreglo();
        }
        System.out.println("1. Español. \n2. English.");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                break;
            case 2:
                break;
        }
        System.out.println("---------- MENU ----------");

    }

}

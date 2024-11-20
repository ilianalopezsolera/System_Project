package Class;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

/**
 * Represents a social media platform where users can share links.
 * This class allows users to choose a social media platform and share 
 * a link through the default web browser.
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
public class RedSocial {

    public RedSocial() {
    }
    
    /**
     * Allows the user to share a link on a selected social media platform.
     * 
     * <p>This method prompts the user to choose whether to share a link. 
     * If the user agrees, they can select one of three available social media 
     * platforms (Twitter, Instagram, or Facebook).The corresponding URL is 
     * opened in the default browser using the Desktop class. The user can 
     * continue sharing the link on other social media platforms or exit 
     * the process.</p>
     * 
     */
    public void shareLink() {
        Scanner leer = new Scanner(System.in);

        System.out.println("Desea compartirlo en una red social \n1.Si 2.No");
        int respuesta = leer.nextInt();

        if (respuesta == 1) {
            while (respuesta == 1) {

                System.out.println("¿Que red social? \n1.Twitter"
                        + " 2.Instagram 3.Facebook");
                int red = leer.nextInt();

                if (red == 1) {
                    try {

                        String url = "https://twitter.com";

                        if (Desktop.isDesktopSupported()) {

                            Desktop desktop = Desktop.getDesktop();

                            desktop.browse(new URI(url));

                        } else {
                            System.out.println("El sistema no soporta"
                                    + " la clase Desktop.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (red == 2) {
                    try {

                        String url = "https://instagram.com";

                        if (Desktop.isDesktopSupported()) {

                            Desktop desktop = Desktop.getDesktop();

                            desktop.browse(new URI(url));

                        } else {
                            System.out.println("El sistema no soporta"
                                    + " la clase Desktop.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (red == 3) {
                    try {

                        String url = "https://Facebook.com";

                        if (Desktop.isDesktopSupported()) {

                            Desktop desktop = Desktop.getDesktop();

                            desktop.browse(new URI(url));

                        } else {
                            System.out.println("El sistema no soporta la"
                                    + " clase Desktop.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Desea compartirlo en otra"
                        + " red social \n1.Si 2.No");
                respuesta = leer.nextInt();
            }
        } else {

        }
    } 
}

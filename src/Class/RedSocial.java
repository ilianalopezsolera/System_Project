package Class;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class RedSocial {

    private String token;

    public RedSocial() {
    }

    public RedSocial(String token) {
        this.token = token;
    }
    
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

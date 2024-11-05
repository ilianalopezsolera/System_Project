/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author ilico
 */
public class SportSpace {

    private String name;

    private String type;

    private int price;

    public SportSpace() {
    }

    public SportSpace(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void llenarArreglo() {

        System.out.println("Nombre: " + name + ", tipo: " + type + ", precio: " 
                + price);
        
    }

    public void seeAvailability() {
    }

    @Override
    public String toString() {
        return "SportSpace{" + "name=" + name + ", type=" + type +
                ", price=" + price + '}';
    }

}

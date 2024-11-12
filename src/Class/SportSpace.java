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
    
    private boolean availability = true;

    private int price;
    
    private int spaces = 10;

    public SportSpace() {
    }

    public SportSpace(String name, String type, boolean availability,int price) {
        this.name = name;
        this.type = type;
        this.availability = availability;
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

    public boolean getAvailability() {
        return availability;
    }
    
    public void setAvailability(boolean availability){
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }
    
    public SportSpace[] fillSportSpace(){
        SportSpace[] sp = new SportSpace[spaces];
        sp[0] = new SportSpace("Baloncesto", "Tipo", true, 2000);
        sp[1] = new SportSpace("Futbol", "Tipo", true, 2000);
        sp[2] = new SportSpace("Gimnasio", "Tipo", true, 2000);
        return sp;
    }
    
    public void showAvailability(){
        
    }
    /**
     * 
     */
    public void seeAvailability() {
    }

    @Override
    public String toString() {
        return "SportSpace{" + "name=" + name + ", type=" + type +
                ", price=" + price + '}';
    }

}

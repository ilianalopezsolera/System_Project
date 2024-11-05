package System;

public class SportSpace {

    private String name;

    private String location;

    private String type;

    private int price;

    public SportSpace() {
    }

    public SportSpace(String name, String location, String type, int price) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    
    public void seeAvailability() {
    }

    @Override
    public String toString() {
        return "SportSpace{" + "name=" + name + ", location=" + location +
                ", type=" + type + ", price=" + price + '}';
    }
    
}

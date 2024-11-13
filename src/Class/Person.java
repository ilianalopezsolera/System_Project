package Class;

public abstract class Person implements Language {

    private String name;

    private String IDPerson;

    private String carnet;

    private Contact contact;

    public Person() {
    }

    public Person(String name, String IDPerson, String carnet, 
            Contact contact) {
        this.name = name;
        this.IDPerson = IDPerson;
        this.carnet = carnet;
        this.contact = contact;
    }

    public Person(String name, String IDPerson, Contact contact) {
        this.name = name;
        this.IDPerson = IDPerson;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", IDPerson=" + IDPerson +
                ", password=" + carnet + ", contact=" + contact + '}';
    }
    
}

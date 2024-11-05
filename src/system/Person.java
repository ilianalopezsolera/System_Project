package System;

public abstract class Person implements Language, UserControlInterface {

    private String name;

    private String IDPerson;

    private String password;

    private Contact contact;

    public Person() {
    }

    public Person(String name, String IDPerson, String password, Contact contact) {
        this.name = name;
        this.IDPerson = IDPerson;
        this.password = password;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", IDPerson=" + IDPerson +
                ", password=" + password + ", contact=" + contact + '}';
    }
    
}

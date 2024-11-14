package Class;

import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDPerson() {
        return IDPerson;
    }

    public void setIDPerson(String IDPerson) {
        this.IDPerson = IDPerson;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.IDPerson, other.IDPerson)) {
            return false;
        }
        if (!Objects.equals(this.carnet, other.carnet)) {
            return false;
        }
        return Objects.equals(this.contact, other.contact);
    }

    @Override
    public String toString() {
        return "name: " + name + ", identifier: " + IDPerson + ", contact " + contact;
    }
    
    
}

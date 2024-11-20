package Class;

/**
 * Represents contact information, including email and phone number.
 * <p>This class provides the basic structure to store and manage a person's 
 * contact details such as email and phone number.</p>
 * 
 * @author Meylin Lopez
 * @author Carlos Rodriguez
 * @author Dilan Gonzales
 * @author Reychell Acuña
 */
public class Contact {

    private String mail;

    private long phone;

    public Contact() {
    }

    public Contact(String mail, long phone) {
        this.mail = mail;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the object containing mail and phone 
     * attributes.
     * 
     * <p>This method overrides the default toString method to provide a custom 
     * string representation of the object, showing the mail and phone 
     * attributes.</p>
     * 
     * @return a string representing the object with the format:
     * "mail: [mail], phone: [phone]"
     */
    @Override
    public String toString() {
        return "mail: " + mail + ", phone: " + phone;
    }
    
}

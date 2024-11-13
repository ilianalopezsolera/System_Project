package Class;

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

    @Override
    public String toString() {
        return "Contact{" + "mail=" + mail + ", phone=" + phone + '}';
    }
    
}

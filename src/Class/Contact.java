package Class;

public class Contact {

    private String mail;

    private String phone;

    public Contact() {
    }

    public Contact(String mail, String phone) {
        this.mail = mail;
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "mail=" + mail + ", phone=" + phone + '}';
    }
    
}

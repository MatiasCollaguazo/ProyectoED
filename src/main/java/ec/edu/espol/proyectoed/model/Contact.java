package ec.edu.espol.proyectoed.model;
import com.google.gson.Gson;
/**
 * 
 * @author Matías_Collaguazo
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private ArrayCustom<Contact> contacts = new ArrayCustom<>();
    private LinkedListCustom< Attribute<String,String> > additionalAttributes;

    /**
     * Constructor to create a contact with essential information.
     * @param firstName the contact's first name
     * @param lastName the contact's last name
     * @param phoneNumber the contact's primary phone number
     * @param email the contact's email address
     */
    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.additionalAttributes = new LinkedListCustom<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedListCustom getAdditionalAttributes(){
        return additionalAttributes;
    }
    
    public ArrayCustom getContacts(){
        return contacts;
    }
    
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

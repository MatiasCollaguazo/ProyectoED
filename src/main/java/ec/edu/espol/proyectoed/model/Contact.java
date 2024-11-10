package ec.edu.espol.proyectoed.model;
import com.google.gson.Gson;
/**
 * 
 * @author Matías_Collaguazo
 */
public abstract class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private ArrayCustom<Contact> contacts = new ArrayCustom<>();
    private LinkedListCustom< Attribute<String,String> > additionalAttributes;

    /**
     * @param name the contact's name
     * @param phoneNumber the contact's primary phone number
     * @param email the contact's email address
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.additionalAttributes = new LinkedListCustom<>();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name=name;
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

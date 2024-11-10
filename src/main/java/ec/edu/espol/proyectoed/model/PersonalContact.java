package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class PersonalContact extends Contact{
    private String lastName;
    public PersonalContact(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, phoneNumber, email);
        this.lastName = lastName;
    }

    public void setFirstName(String name) {
        setName(name);
    }
    
    public String getFirstName(){
        return getName();
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}

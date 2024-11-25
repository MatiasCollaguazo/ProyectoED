package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
//This class operates as a template of the display style of selected contact on the contact agend
public class PersonalContact extends Contact {
    private final ContactType type = ContactType.PERSONAL;
    public PersonalContact() {

    }

    public ContactType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "PersonalContact {" + super.toString() + "}";
    }

}

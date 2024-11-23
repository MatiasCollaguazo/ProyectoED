package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
//This class operates as a template of the display style of selected contact on the contact agend
public class CompanyContact extends Contact {
    private final ContactType type = ContactType.COMPANY;
    public CompanyContact() {

    }
    
    public ContactType getType(){
        return type;
    }
}

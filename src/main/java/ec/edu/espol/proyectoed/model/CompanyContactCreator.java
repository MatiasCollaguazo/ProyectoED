package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías Collaguazo
 */
public class CompanyContactCreator extends ContactCreator{
    @Override
    public Contact createContact(String name, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        contact.getMainAttributes().add(new Attribute<>("First Name", name));
        contact.getMainAttributes().add(new Attribute<>("Phone Number", phoneNumber));
        
        return contact;
    }
    
    
    public Contact createContact(String name, String companyName, String phoneNumber) {
        Contact contact = createContact(name, phoneNumber);
        contact.getMainAttributes().add(new Attribute<>("Company Name", companyName));
        
        return contact;
    }
    
    public Contact createContact(String name, String companyName, String phoneNumber, String email) {
        Contact contact = createContact(name, companyName, phoneNumber);
        contact.getMainAttributes().add(new Attribute<>("Email", email));
        
        return contact;
    }
}

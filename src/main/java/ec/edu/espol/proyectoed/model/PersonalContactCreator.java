package ec.edu.espol.proyectoed.model;

/**
 *
 * @author CltControl
 */
public class PersonalContactCreator extends ContactCreator {
    @Override
    public Contact createContact(String name, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        contact.getMainAttributes().add(new Attribute<>("First Name", name));
        contact.getMainAttributes().add(new Attribute<>("Phone Number", phoneNumber));
        
        return contact;
    }
    
    
    public Contact createContact(String name, String lastName, String phoneNumber) {
        Contact contact = createContact(name, phoneNumber);
        contact.getMainAttributes().add(new Attribute<>("Last Name", lastName));
        
        return contact;
    }
    
    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        Contact contact = createContact(name, lastName, phoneNumber);
        contact.getMainAttributes().add(new Attribute<>("Email", email));
        
        return contact;
    }

}
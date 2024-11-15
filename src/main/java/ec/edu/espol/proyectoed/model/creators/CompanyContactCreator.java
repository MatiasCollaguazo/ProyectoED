package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.CompanyContact;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.LinkedListCustom;


/**
 *
 * @author Matías Collaguazo
 */
public class CompanyContactCreator extends ContactCreator{
    @Override
    public Contact createContact(String name, String phoneNumber) {
        CompanyContact contact = new CompanyContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        
        return contact;
    }
    
    
    public Contact createContact(String name, String companyName, String phoneNumber) {
        Contact contact = createContact(name, phoneNumber);
        contact.getMainAttributes().add(new ContactAttribute<>(Attributes.COMPANY_NAME, companyName));
        
        return contact;
    }
    
    public Contact createContact(String name, String companyName, String phoneNumber, String email) {
        Contact contact = createContact(name, companyName, phoneNumber);
        contact.getMainAttributes().add(new ContactAttribute<>("Email", email));
        
        return contact;
    }
}

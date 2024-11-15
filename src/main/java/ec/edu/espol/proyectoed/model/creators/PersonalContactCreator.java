package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.PersonalContact;

/**
 *
 * @author CltControl
 */
public class PersonalContactCreator extends ContactCreator {

    @Override
    public Contact createContact(String name, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        contact.getMainAttributes().add(new ContactAttribute<>("First Name", name));
        contact.getMainAttributes().add(new ContactAttribute<>("Phone Number", phoneNumber));

        return contact;
    }

    public Contact createContact(String name, String lastName, String phoneNumber) {
        Contact contact = createContact(name, phoneNumber);
        contact.getMainAttributes().add(new ContactAttribute<>("Last Name", lastName));

        return contact;
    }

    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        Contact contact = createContact(name, lastName, phoneNumber);
        contact.getMainAttributes().add(new ContactAttribute<>("Email", email));

        return contact;
    }

}

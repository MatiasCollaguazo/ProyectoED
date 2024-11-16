package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.LinkedListCustom;
import ec.edu.espol.proyectoed.model.PersonalContact;

/**
 *
 * @author CltControl
 */
public class PersonalContactCreator extends ContactCreator {

    @Override
    public Contact createContact(String name, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, ""));
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, ""));

        return contact;
    }

    public Contact createContact(String name, String lastName, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, lastName));
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, ""));
        
        return contact;
    }

    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        PersonalContact contact = new PersonalContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, lastName));
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, email));

        return contact;
    }

}

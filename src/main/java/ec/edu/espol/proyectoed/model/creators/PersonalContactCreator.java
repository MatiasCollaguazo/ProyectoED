package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.PersonalContact;

public class PersonalContactCreator extends ContactCreator {

    @Override
    public Contact createContact(String name, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        addDefaultAttributes(contact, name, "", phoneNumber, "", "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber) {
        PersonalContact contact = new PersonalContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, "", "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        PersonalContact contact = new PersonalContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, email, "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email, String companyName) {
        PersonalContact contact = new PersonalContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, email, companyName, "", "", "", "");
        return contact;
    }

    public Contact createContact() {
        PersonalContact contact = new PersonalContact();
        addDefaultAttributes(contact); // Todos los valores estarán vacíos por defecto.
        return contact;
    }
}

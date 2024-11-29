package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.CompanyContact;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;

public class CompanyContactCreator extends ContactCreator {

    @Override
    public Contact createContact(String name, String phoneNumber) {
        CompanyContact contact = new CompanyContact();
        addDefaultAttributes(contact, name, "", phoneNumber, "", "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber) {
        CompanyContact contact = new CompanyContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, "", "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        CompanyContact contact = new CompanyContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, email, "", "", "", "", "");
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email, String companyName) {
        CompanyContact contact = new CompanyContact();
        addDefaultAttributes(contact, name, lastName, phoneNumber, email, companyName, "", "", "", "");
        return contact;
    }

    public Contact createContact() {
        CompanyContact contact = new CompanyContact();
        addDefaultAttributes(contact); // Todos los valores estarán vacíos por defecto.
        return contact;
    }
}

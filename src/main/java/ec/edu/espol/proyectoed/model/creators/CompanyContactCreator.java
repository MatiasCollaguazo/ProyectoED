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
public class CompanyContactCreator extends ContactCreator {

    @Override
    public Contact createContact(String name, String phoneNumber) {
        CompanyContact contact = new CompanyContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, ""));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, ""));
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, ""));
        
        contact.setAttribute(Attributes.FIRST_NAME.getDisplayName(), name);
        contact.setAttribute(Attributes.LAST_NAME.getDisplayName(), "");
        contact.setAttribute(Attributes.PHONE_NUMBER.getDisplayName(), phoneNumber);
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), "");
        contact.setAttribute(Attributes.EMAIL.getDisplayName(), "");

        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber) {
        CompanyContact contact = new CompanyContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, lastName));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contactAttributes.add(new ContactAttribute<>(Attributes.COMPANY_NAME, ""));
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, ""));
        
        contact.setAttribute(Attributes.FIRST_NAME.getDisplayName(), name);
        contact.setAttribute(Attributes.LAST_NAME.getDisplayName(), lastName);
        contact.setAttribute(Attributes.PHONE_NUMBER.getDisplayName(), phoneNumber);
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), "");
        contact.setAttribute(Attributes.EMAIL.getDisplayName(), "");
        
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email) {
        CompanyContact contact = new CompanyContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, lastName));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), "");
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, email));

        
        contact.setAttribute(Attributes.FIRST_NAME.getDisplayName(), name);
        contact.setAttribute(Attributes.LAST_NAME.getDisplayName(), lastName);
        contact.setAttribute(Attributes.PHONE_NUMBER.getDisplayName(), phoneNumber);
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), "");
        contact.setAttribute(Attributes.EMAIL.getDisplayName(), email);
        
        return contact;
    }

    @Override
    public Contact createContact(String name, String lastName, String phoneNumber, String email, String companyName) {
        CompanyContact contact = new CompanyContact();
        LinkedListCustom contactAttributes = contact.getMainAttributes();
        contactAttributes.add(new ContactAttribute<>(Attributes.FIRST_NAME, name));
        contactAttributes.add(new ContactAttribute<>(Attributes.LAST_NAME, lastName));
        contactAttributes.add(new ContactAttribute<>(Attributes.PHONE_NUMBER, phoneNumber));
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), companyName);
        contactAttributes.add(new ContactAttribute<>(Attributes.EMAIL, email));

        
        contact.setAttribute(Attributes.FIRST_NAME.getDisplayName(), name);
        contact.setAttribute(Attributes.LAST_NAME.getDisplayName(), lastName);
        contact.setAttribute(Attributes.PHONE_NUMBER.getDisplayName(), phoneNumber);
        contact.setAttribute(Attributes.COMPANY_NAME.getDisplayName(), companyName);
        contact.setAttribute(Attributes.EMAIL.getDisplayName(), email);
        
        return contact;
    }
}
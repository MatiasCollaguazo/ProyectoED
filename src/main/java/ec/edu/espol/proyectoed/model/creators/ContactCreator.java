package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class ContactCreator {
    protected void addDefaultAttributes(Contact contact, String... values) {
        Attributes[] allAttributes = Attributes.values();
        ArrayCustom contactAttributes = contact.getMainAttributes();

        for (int i = 0; i < allAttributes.length; i++) {
            String value = i < values.length ? values[i] : "";
            contactAttributes.add(new ContactAttribute<>(allAttributes[i], value));
            
            //@CompabilityFeature
            contact.setAttribute(allAttributes[i].getDisplayName(), value);
        }
    }
    public abstract Contact createContact(String name, String phoneNumber);
    public abstract Contact createContact(String name, String lastName, String phoneNumber);
    public abstract Contact createContact(String name, String lastName, String phoneNumber, String email);
    public abstract Contact createContact(String name, String lastName, String phoneNumber, String email, String companyName);
    
}

package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.Contact;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class ContactCreator {
    public abstract Contact createContact(String name, String phoneNumber);
    public abstract Contact createContact(String name, String lastName, String phoneNumber);
    public abstract Contact createContact(String name, String lastName, String phoneNumber, String email);
    public abstract Contact createContact(String name, String lastName, String phoneNumber, String email, String companyName);
}

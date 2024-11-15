package ec.edu.espol.proyectoed.model.creators;

import ec.edu.espol.proyectoed.model.Contact;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class ContactCreator {
    public abstract Contact createContact(String name, String phoneNumber);
}
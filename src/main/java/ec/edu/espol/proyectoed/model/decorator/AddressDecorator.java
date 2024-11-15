package ec.edu.espol.proyectoed.model.decorator;

import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;

/**
 *
 * @author Matías_Collaguazo
 */
public class AddressDecorator extends ContactDecorator {

    public AddressDecorator(Contact decoratedContact, String address) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new ContactAttribute<>("Address", address));
    }
}

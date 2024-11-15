package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class AddressDecorator extends ContactDecorator {

    public AddressDecorator(Contact decoratedContact, String address) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new Attribute<>("Address", address));
    }
}
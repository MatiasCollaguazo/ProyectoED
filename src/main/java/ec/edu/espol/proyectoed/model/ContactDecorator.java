package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class ContactDecorator extends Contact {
    protected Contact decoratedContact;

    public ContactDecorator(Contact decoratedContact) {
        super();
        this.decoratedContact = decoratedContact;
    }

    @Override
    public LinkedListCustom<Attribute<String, String>> getMainAttributes() {
        return decoratedContact.getMainAttributes();
    }

    @Override
    public LinkedListCustom<Attribute<String, String>> getAdditionalAttributes() {
        return decoratedContact.getAdditionalAttributes();
    }
}
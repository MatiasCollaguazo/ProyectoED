package ec.edu.espol.proyectoed.model.decorator;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;

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
    public ArrayCustom<ContactAttribute<String, String>> getMainAttributes() {
        return decoratedContact.getMainAttributes();
    }

    @Override
    public ArrayCustom<ContactAttribute<String, String>> getAdditionalAttributes() {
        return decoratedContact.getAdditionalAttributes();
    }
    
    
    public abstract void addComponent();
}

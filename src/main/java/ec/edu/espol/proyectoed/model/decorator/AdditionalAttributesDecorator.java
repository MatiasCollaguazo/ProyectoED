package ec.edu.espol.proyectoed.model.decorator;

import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;

/**
 *
 * @author Matias Collaguazo
 */
public class AdditionalAttributesDecorator extends ContactDecorator {

    public AdditionalAttributesDecorator(Contact decoratedContact) {
        super(decoratedContact);
    }

    public AdditionalAttributesDecorator(Contact decoratedContact, String value) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new ContactAttribute<>(Attributes.LABELS,value));
    }

    @Override
    public void addComponent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

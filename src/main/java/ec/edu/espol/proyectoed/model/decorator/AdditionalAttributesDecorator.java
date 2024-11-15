package ec.edu.espol.proyectoed.model.decorator;

import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import java.time.LocalDate;

/**
 *
 * @author Matias Collaguazo
 */
public class AdditionalAttributesDecorator extends ContactDecorator{
    
    public AdditionalAttributesDecorator(Contact decoratedContact) {
        super(decoratedContact);
    }
    
    public AdditionalAttributesDecorator(Contact decoratedContact, LocalDate birthday) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new ContactAttribute<>("Birthday", birthday.toString()));
    }
}

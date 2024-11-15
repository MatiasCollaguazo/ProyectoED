package ec.edu.espol.proyectoed.model;

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
        this.decoratedContact.getAdditionalAttributes().add(new Attribute<>("Birthday", birthday.toString()));
    }
}

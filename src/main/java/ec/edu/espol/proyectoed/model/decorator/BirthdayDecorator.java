package ec.edu.espol.proyectoed.model.decorator;

import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.Contact;
import java.time.LocalDate;

/**
 *
 * @author Matías_Collaguazo
 */
public class BirthdayDecorator extends ContactDecorator {

    public BirthdayDecorator(Contact decoratedContact, LocalDate birthday) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new ContactAttribute<>(Attributes.BIRTHDAY.getDisplayName(), birthday.toString()));
    }
}

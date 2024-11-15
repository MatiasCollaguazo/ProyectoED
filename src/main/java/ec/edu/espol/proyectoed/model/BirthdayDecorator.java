package ec.edu.espol.proyectoed.model;

import java.time.LocalDate;

/**
 *
 * @author Matías_Collaguazo
 */
public class BirthdayDecorator extends ContactDecorator {

    public BirthdayDecorator(Contact decoratedContact, LocalDate birthday) {
        super(decoratedContact);
        this.decoratedContact.getAdditionalAttributes().add(new Attribute<>("Birthday", birthday.toString()));
    }
}
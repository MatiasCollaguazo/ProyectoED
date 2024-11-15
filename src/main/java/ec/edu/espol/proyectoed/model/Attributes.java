package ec.edu.espol.proyectoed.model;

/**
 *
 * @author matia
 */
public enum Attributes {
    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    PHONE_NUMBER("Phone Number"),
    EMAIL("Email"),
    ADDRESS("Address"),
    COMPANY_NAME("Company Name"),
    BIRTHDAY("Birthday"),
    DYNAMIC("");

    private final String displayName;

    Attributes(String displayName) {
        this.displayName = displayName;
    }
}

package ec.edu.espol.proyectoed.model;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Attributes {
    FIRST_NAME,
    LAST_NAME,
    PHONE_NUMBER,
    EMAIL,
    ADDRESS,
    COMPANY_NAME,
    BIRTHDAY,
    COUNTRY,
    LABELS;

    private static Locale currentLocale = Locale.getDefault();
    private static ResourceBundle bundle = ResourceBundle.getBundle("messages", currentLocale);

    public static void setLocale(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle("messages", currentLocale);
    }

    public String getDisplayName() {
        return bundle.getString(this.name());
    }
}

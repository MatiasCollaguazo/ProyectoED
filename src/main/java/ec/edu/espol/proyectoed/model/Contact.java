package ec.edu.espol.proyectoed.model;

import com.google.gson.Gson;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class Contact {

    private ArrayCustom<Contact> contacts = new ArrayCustom<>();
    private LinkedListCustom< ContactAttribute<String, String>> mainAttributes;
    private LinkedListCustom< ContactAttribute<String, String>> additionalAttributes;

    public Contact() {
        this.mainAttributes = new LinkedListCustom<>();
        this.additionalAttributes = new LinkedListCustom<>();
    }

    public LinkedListCustom getMainAttributes() {
        return mainAttributes;
    }

    public LinkedListCustom getAdditionalAttributes() {
        return additionalAttributes;
    }

    public ArrayCustom getContacts() {
        return contacts;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

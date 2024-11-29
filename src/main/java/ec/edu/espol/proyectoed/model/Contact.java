package ec.edu.espol.proyectoed.model;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class Contact {

    private LinkedListCustom<Contact> contacts = new LinkedListCustom<>();
    private final ArrayCustom< ContactAttribute<String, String>> mainAttributes;
    private final ArrayCustom< ContactAttribute<String, String>> additionalAttributes;

    /*
        @CompabilityFeature
     */
    private final Map<String, String> attributes;

    public Contact() {
        this.mainAttributes = new ArrayCustom<>();
        this.additionalAttributes = new ArrayCustom<>();

        //@CompabilityFeature
        this.attributes = new HashMap<>();
    }

    public ArrayCustom getMainAttributes() {
        return mainAttributes;
    }

    public ArrayCustom getAdditionalAttributes() {
        return additionalAttributes;
    }

    public LinkedListCustom getContacts() {
        return contacts;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    //@CompabilityFeature
    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(Attributes key) {
        return attributes.get(key.getDisplayName());
    }

}

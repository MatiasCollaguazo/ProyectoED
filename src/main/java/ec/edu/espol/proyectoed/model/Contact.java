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
    private LinkedListCustom< ContactAttribute<String, String>> mainAttributes;
    private LinkedListCustom< ContactAttribute<String, String>> additionalAttributes;
    
    /*
        @CompabilityFeature
    */
    private Map<String, String> attributes;

    public Contact() {
        this.mainAttributes = new LinkedListCustom<>();
        this.additionalAttributes = new LinkedListCustom<>();
        
        //@CompabilityFeature
        this.attributes = new HashMap<>();
    }

    public LinkedListCustom getMainAttributes() {
        return mainAttributes;
    }

    public LinkedListCustom getAdditionalAttributes() {
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

    public String getAttribute(String key) {
        return attributes.get(key);
    }
    
}

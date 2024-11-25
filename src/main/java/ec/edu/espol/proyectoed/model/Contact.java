package ec.edu.espol.proyectoed.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matías_Collaguazo
 */
public abstract class Contact {

    private LinkedListCustom<Contact> contacts = new LinkedListCustom<>();
    @Expose
    private LinkedListCustom< ContactAttribute<String, String>> mainAttributes;
    @Expose
    private LinkedListCustom< ContactAttribute<String, String>> additionalAttributes;

    /*
        @CompabilityFeature
     */
    @Expose
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
        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() // Respetar @Expose
            .setPrettyPrinting()                   // Formatear el JSON
            .create();



        // Convertir listas personalizadas a listas estándar
        JsonObject jsonObject = gson.toJsonTree(this).getAsJsonObject();
        jsonObject.add("mainAttributes", gson.toJsonTree(mainAttributes.toList()));
        jsonObject.add("additionalAttributes", gson.toJsonTree(additionalAttributes.toList()));

        return gson.toJson(jsonObject);
    }


    //@CompabilityFeature
    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(Attributes key) {
        return attributes.get(key.getDisplayName());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact {");
        sb.append("Attributes: [");
        for (int i = 0; i < this.getAdditionalAttributes().getSize(); i++) {
            ContactAttribute<String, String> attribute = (ContactAttribute<String, String>) this.getAdditionalAttributes().get(i);
            sb.append(attribute.getAttributeName()).append(": ").append(attribute.getValue());
            if (i < this.getAdditionalAttributes().getSize() - 1) sb.append(", ");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

    

}

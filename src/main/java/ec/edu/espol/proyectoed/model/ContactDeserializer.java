/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Nehemías
 */
import com.google.gson.*;
import java.lang.reflect.Type;

public class ContactDeserializer implements JsonDeserializer<Contact> {
    @Override
    public Contact deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String contactType = jsonObject.get("type").getAsString(); // Extraer el tipo

        // Decidir qué subclase instanciar
        if ("PERSONAL".equals(contactType)) {
            return context.deserialize(json, PersonalContact.class);
        } else if ("COMPANY".equals(contactType)) {
            return context.deserialize(json, CompanyContact.class);
        } else {
            throw new JsonParseException("Unknown contact type: " + contactType);
        }
    }
}

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

public class ContactAdapter implements JsonSerializer<Contact>, JsonDeserializer<Contact> {

    @Override
    public JsonElement serialize(Contact src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName()); // Agregar el tipo de la subclase
        return jsonObject;
    }

    @Override
    public Contact deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString(); // Obtener el tipo del contacto

        try {
            // Determinar la clase de la subclase a partir del tipo
            Class<?> clazz = Class.forName("tu.paquete." + type);
            return context.deserialize(jsonObject, clazz);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Tipo de contacto desconocido: " + type, e);
        }
    }
}

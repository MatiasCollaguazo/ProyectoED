package ec.edu.espol.proyectoed.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author Matías_Collaguazo
 */
public class ContactManager {

    private static ContactManager instance;
    private Contact user;
    private LinkedListCustom<Contact> contacts;
    private Contact currentSelectedContact; //Differs of user in UI

    private ContactManager() {
        contacts = new LinkedListCustom<>();
    }

    /**
     * Provides access to the single instance of ContactManager. If the instance
     * doesn't exist, it creates one.
     *
     * @return the single instance of ContactManager
     */
    public static ContactManager getInstance() {
        if (instance == null) {
            instance = new ContactManager();
        }
        return instance;
    }

    public void setUser(Contact user) {
        this.user = user;
        this.contacts = user.getContacts();
    }

    public Contact getUser() {
        return user;
    }

    public Contact getCurrentSelectedContact() {
        return currentSelectedContact;
    }

    public void setCurrentSelectedContact(Contact currentSelectedContact) {
        this.currentSelectedContact = currentSelectedContact;
    }

    /**
     * Adds a new contact to the list.
     *
     * @param contact the contact to add
     */
    public synchronized void addContact(Contact contact) {
        if (contact != null) {
            contacts.add(contact);

            // Imprimir el contacto que se está agregando
            System.out.println("Contacto agregado: " + contact.toJson());
            saveContactsToJson();
        } else {
            throw new NullPointerException("Cannot add a null contact. Error ProyectoED Failed01");
        }
    }

    /**
     * Adds a new contact to the list.
     *
     * @param contact the contact to add
     */
    public synchronized void removeContact(Contact contact) {
        if (contact != null) {

        } else {
            throw new NullPointerException("Cannot remove a null contact. Error ProyectoED Failed05");
        }
    }

    /*
        Here can be added a removeContact() method, but
        i don't know if we will use serializableID or an artificial ID
     */
    /**
     * @param contact the contact to which the attribute will be added
     * @param attributeName the name of the attribute (e.g., "Facebook",
     * "Instagram", "Discord)
     * @param value the value associated with this attribute
     */
    public void addAttribute(Contact contact, String attributeName, String value) {
        ContactAttribute<String, String> attribute = new ContactAttribute<>(attributeName, value);
        contact.getAdditionalAttributes().add(attribute);
    }

    /**
     * Adds a atribute to current user contact
     *
     * @param attributeName the name of the attribute (e.g., "Facebook",
     * "Instagram", "Discord)
     * @param value the value associated with this attribute
     */
    public void addAttribute(String attributeName, String value) {
        ContactAttribute<String, String> attribute = new ContactAttribute<>(attributeName, value);
        this.getUser().getAdditionalAttributes().add(attribute);
    }

    /**
     * @param contact the contact from which the attribute is retrieved
     * @param attributeName the name of the attribute
     * @return the value of the attribute or null if it doesn't exist
     */
    public String getAttribute(Contact contact, String attributeName) {
        for (int i = 0; i < contact.getAdditionalAttributes().getSize(); i++) {
            ContactAttribute<String, String> attribute = (ContactAttribute<String, String>) contact.getAdditionalAttributes().get(i);
            if (attribute.getAttributeName().equals(attributeName)) {
                return attribute.getValue();
            }
        }
        return null;
    }

    /**
     * Gets the attribute from the current user contact
     *
     * @param attributeName the name of the attribute
     * @return the value of the attribute or null if it doesn't exist
     */
    public String getAttribute(String attributeName) {
        for (int i = 0; i < this.getUser().getAdditionalAttributes().getSize(); i++) {
            ContactAttribute<String, String> attribute = (ContactAttribute<String, String>) this.getUser().getAdditionalAttributes().get(i);
            if (attribute.getAttributeName().equals(attributeName)) {
                return attribute.getValue();
            }
        }
        return null;
    }

    /**
     * @param contact the contact from which the attribute will be removed
     * @param attributeName the name of the attribute to remove
     */
    public void removeAttribute(Contact contact, String attributeName) {
        //May create a "ListCustom" class would be a effective manner to change the data structure here
        LinkedListCustom<ContactAttribute<String, String>> additionalAttributes;
        if (contact.getAdditionalAttributes() != null) {
            additionalAttributes = contact.getAdditionalAttributes();
        } else {
            throw new NullPointerException(contact.toString() + "doesn't have additional attributes. Error ProyectoED Failed02");
        }
        for (int i = 0; i < contact.getAdditionalAttributes().getSize(); i++) {
            //The next line may cause trash operations, use of Iterator design or class may be a good option
            if (additionalAttributes.get(i).getAttributeName().equals(attributeName)) {
                contact.getAdditionalAttributes().remove(i);
                break;
            }
        }
    }

    public synchronized LinkedListCustom<Contact> getAllContacts() {
        if (contacts == null) {
            contacts = new LinkedListCustom<>();
        }
        return contacts;
    }
    
    //2)Funcionalidad para visualizar la lista de contactos.
    //En realidad ya esta implementado en la interfaz gráfica
    public void listContacts() { 
        if (contacts.getSize() == 0) {
            System.out.println("No contacts available");
        } else {
            for (int i = 0; i < contacts.getSize(); i++) {
                Contact contact = contacts.get(i);
                System.out.println(contact.toJson());
            }
        }
    }

public void saveContactsToJson() {
    try {
        List<Contact> contactList = contacts.toList();

        // Configurar Gson con el adaptador personalizado
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Contact.class, new ContactAdapter()) // Adaptador para manejar subclases
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

        String json = gson.toJson(contactList);

        // Escribir el JSON en el archivo
        try (FileWriter fileWriter = new FileWriter("contacts.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        }

        System.out.println("Contactos guardados en contacts.json");

    } catch (IOException e) {
        System.err.println("Error al guardar contactos: " + e.getMessage());
    }
}



    
    public void loadContactsFromJson() {
        File file = new File("contacts.json");
        if (!file.exists()) {
            System.out.println("El archivo contacts.json no existe. Iniciando con una lista vacía.");
            return; // No hay nada que cargar
        }

        try (FileReader reader = new FileReader(file)) {
            // Tipo genérico para una lista de contactos
            Type listType = new TypeToken<List<Contact>>() {}.getType();

            // Usar el Gson configurado con el deserializador
            Gson gson = new GsonBuilder()
                .registerTypeAdapter(Contact.class, new ContactDeserializer())
                .excludeFieldsWithoutExposeAnnotation()
                .create();

            // Deserializar el JSON en una lista de contactos
            List<Contact> contactList = gson.fromJson(reader, listType);

            // Agregar los contactos deserializados a la LinkedListCustom
            for (Contact contact : contactList) {
                contacts.add(contact);
            }

            System.out.println("Contactos cargados desde contacts.json.");
        } catch (IOException e) {
            System.err.println("Error al cargar contactos: " + e.getMessage());
        }
    }
    
    
    public boolean updateContactAttribute(String contactIdentifier, String attributeName, String newValue) {
        // Obtener la lista de contactos
        List<Contact> contactList = contacts.toList();

        // Recorrer la lista para buscar el contacto
        for (Contact contact : contactList) {
            // Verificar si el contacto tiene el identificador buscado
            for (Object obj : contact.getAdditionalAttributes().toList()) {
            // Convertir explícitamente a ContactAttribute<String, String>
            ContactAttribute<String, String> attribute = (ContactAttribute<String, String>) obj;

            if (attribute.getAttributeName().equals("First Name") && attribute.getValue().equals(contactIdentifier)) {
                // Buscar el atributo que se desea actualizar
                for (Object obj2 : contact.getAdditionalAttributes().toList()) {
                    ContactAttribute<String, String> attr = (ContactAttribute<String, String>) obj2;

                    if (attr.getAttributeName().equals(attributeName)) {
                        // Actualizar el valor del atributo
                        attr.setValue(newValue);
                        System.out.println("Atributo actualizado: " + attributeName + " = " + newValue);
                        return true;
                    }
                }
            }
    }

        }
        System.out.println("Contacto o atributo no encontrado.");
        return false;
    }

}

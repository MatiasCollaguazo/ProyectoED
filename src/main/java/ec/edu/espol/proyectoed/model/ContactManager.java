package ec.edu.espol.proyectoed.model;

/**
 * 
 * @author Matías_Collaguazo
 */
public class ContactManager {
    private static ContactManager instance;
    private ArrayCustom<Contact> contacts;

    private ContactManager() {} //singleton :P

    /**
     * Provides access to the single instance of ContactManager.
     * If the instance doesn't exist, it creates one.
     * @return the single instance of ContactManager
     */
    public static ContactManager getInstance() {
        if (instance == null) {
            instance = new ContactManager();
        }
        return instance;
    }
    
    
    /**
     * Adds a new contact to the list.
     * @param contact the contact to add
     */
    public void addContact(Contact contact) {
        if (contact != null) {
            contacts.add(contact);
        }else{
            throw new NullPointerException("Cannot add a null contact. Error ProyectoED Failed01");
        }
    }
    
    
    /*
        Here can be added a removeContact() method, but
        i don't know if we will use serializableID or an artificial ID
    */
    
    public void listContacts() {
        if (contacts.getSize() == 0) {
            System.out.println("No contacts available");
        } else {
            for (int i = 0; i < contacts.getSize(); i++) {
                System.out.println(contacts.get(i));
            }
        }
    }
    
    
    /**
     * @param contact the contact to which the attribute will be added
     * @param attributeName the name of the attribute (e.g., "Facebook", "Instagram", "Discord)
     * @param value the value associated with this attribute
     */
    public void addAttribute(Contact contact, String attributeName, String value) {
        Attribute<String, String> attribute = new Attribute<>(attributeName, value);
        contact.getAdditionalAttributes().add(attribute);
    }

    /**
     * @param contact the contact from which the attribute is retrieved
     * @param attributeName the name of the attribute
     * @return the value of the attribute or null if it doesn't exist
     */
    public String getAttribute(Contact contact, String attributeName) {
        for (int i = 0; i < contact.getAdditionalAttributes().getSize(); i++) {
            Attribute<String, String> attribute = (Attribute<String, String>) contact.getAdditionalAttributes().get(i);
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
        LinkedListCustom<Attribute<String,String>> additionalAttributes;
        if (contact.getAdditionalAttributes()!=null) {
            additionalAttributes = contact.getAdditionalAttributes();
        }else{
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
}

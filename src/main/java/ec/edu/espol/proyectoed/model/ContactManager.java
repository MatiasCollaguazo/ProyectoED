package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class ContactManager implements Subject{

    private static ContactManager instance;
    private LinkedListCustom<Observer> observers = new LinkedListCustom<>();
    private Contact user;
    private LinkedListCustom<Contact> contacts;

    private ContactManager() {
        contacts = new LinkedListCustom<>();
    } //singleton :P

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

    public void setUser(Contact user){
        this.user = user;
        this.contacts = user.getContacts();
    }
    
    public Contact getUser(){
        return user;
    }
    
    /**
     * Adds a new contact to the list.
     * @param contact the contact to add
     */
    public synchronized void addContact(Contact contact) {
        if (contact != null) {
            contacts.add(contact);
        } else {
            throw new NullPointerException("Cannot add a null contact. Error ProyectoED Failed01");
        }
    }
    
        /**
     * Adds a new contact to the list.
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
     * @param attributeName the name of the attribute (e.g., "Facebook",
     * "Instagram", "Discord)
     * @param value the value associated with this attribute
     */
    public void addAttribute(Contact contact, String attributeName, String value) {
        ContactAttribute<String, String> attribute = new ContactAttribute<>(attributeName, value);
        contact.getAdditionalAttributes().add(attribute);
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

    // Método para agregar un observador
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para eliminar un observador
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public synchronized void notifyObservers() {
        if (observers.getSize() == 0) {
            return; //No hay observadores :p
        }
        for (int i = 0; i < observers.getSize(); i++) {
            Observer observer = observers.get(i);
            observer.update();
        }
    }

}

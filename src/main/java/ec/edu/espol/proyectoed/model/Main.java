/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author Nehemías
 */
public class Main {
    public static void main(String[] args) {
    ContactManager manager = ContactManager.getInstance();

    // Crear contacto personal
    PersonalContact john = new PersonalContact();
    john.getAdditionalAttributes().add(new ContactAttribute<>("First Name", "John"));
    john.getAdditionalAttributes().add(new ContactAttribute<>("Last Name", "Doe"));
    john.getAdditionalAttributes().add(new ContactAttribute<>("Phone", "+123456789"));
    manager.addContact(john);

    // Crear contacto empresarial
    CompanyContact techCorp = new CompanyContact();
    techCorp.getAdditionalAttributes().add(new ContactAttribute<>("Company Name", "TechCorp"));
    techCorp.getAdditionalAttributes().add(new ContactAttribute<>("Industry", "Technology"));
    manager.addContact(techCorp);

    // Mostrar contactos antes de la modificación
    System.out.println("\nContactos antes de la modificación:");
    for (Contact contact : manager.getAllContacts().toList()) {
        System.out.println(contact.toJson());
    }

    // Actualizar el atributo "Phone" de John
    System.out.println("\n--- Modificando atributo de John ---");
    boolean updated = manager.updateContactAttribute("John", "Phone", "+987654321");

    if (updated) {
        System.out.println("Atributo modificado con éxito.");
    } else {
        System.out.println("No se pudo modificar el atributo.");
    }

    // Mostrar contactos después de la modificación
    System.out.println("\nContactos después de la modificación:");
    for (Contact contact : manager.getAllContacts().toList()) {
        System.out.println(contact.toJson());
    }
}


}

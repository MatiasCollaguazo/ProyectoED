package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.ContactManager;
import ec.edu.espol.proyectoed.model.LinkedListCustom;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.CompanyContact;
import ec.edu.espol.proyectoed.model.ContactType;
import ec.edu.espol.proyectoed.model.PersonalContact;
import ec.edu.espol.proyectoed.model.creators.CompanyContactCreator;
import ec.edu.espol.proyectoed.model.creators.PersonalContactCreator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Matias_Collaguazo
 */
public class ViewContactController implements Initializable {

    private final ContactManager contactManager = ContactManager.getInstance();
    private Contact currentContact = contactManager.getCurrentSelectedContact();

    @FXML
    private ImageView logo;
    @FXML
    private Button createContactButton;
    @FXML
    private Button return_back;
    @FXML
    private ImageView contactImageView1;
    @FXML
    private ImageView contactImageView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private CheckBox isCompanyCheckBox;
    @FXML
    private HBox companyFieldContainer;
    @FXML
    private TextField companyField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button removeButton;
    @FXML
    private ImageView contactImageView2;

    /**
     * Inicializa el controlador
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (currentContact != null) {
            updateContactDetails(currentContact);
        }
    }

    @FXML
    private void switchToAddContactController(ActionEvent event) {
        try {
            App.setRoot("createContact");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cambiar la vista: " + e.getMessage());
        }
    }

    @FXML
    private void switchToPrimaryView(ActionEvent event) {
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cambiar la vista: " + e.getMessage());
        }
    }

    public static void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void loadContactImage(ActionEvent event) {
        boolean isVisible = companyField.isVisible();
        companyField.setVisible(!isVisible);
        companyField.setManaged(!isVisible);
    }

    @FXML
    private void toggleCompanyField(ActionEvent event) {
        boolean isVisible = companyFieldContainer.isVisible();
        companyFieldContainer.setVisible(!isVisible);
        companyFieldContainer.setManaged(!isVisible);
    }

    @FXML
    private void previousContact() {
        companyFieldContainer.setVisible(false);
        companyFieldContainer.setManaged(false);
        LinkedListCustom<Contact> allContacts = contactManager.getAllContacts();
        int currentIndex = allContacts.indexOf(currentContact);

        // Si es el primer contacto, vamos al último
        if (currentIndex == 0) {
            currentContact = allContacts.get(allContacts.getSize() - 1);
        } else {
            currentContact = allContacts.get(currentIndex - 1);
        }
        contactManager.setCurrentSelectedContact(currentContact);
        updateContactDetails(currentContact);
    }

    @FXML
    private void nextContact() {
        companyFieldContainer.setVisible(false);
        companyFieldContainer.setManaged(false);
        LinkedListCustom<Contact> allContacts = contactManager.getAllContacts();
        int currentIndex = allContacts.indexOf(currentContact);

        if (currentIndex == allContacts.getSize() - 1) {
            currentContact = allContacts.get(0);
        } else {
            currentContact = allContacts.get(currentIndex + 1);
        }
        contactManager.setCurrentSelectedContact(currentContact);
        updateContactDetails(currentContact);
    }

    private void updateContactDetails(Contact currentContact) {
        nameField.setText(currentContact.getAttribute(Attributes.FIRST_NAME));
        lastNameField.setText(currentContact.getAttribute(Attributes.LAST_NAME));
        emailField.setText(currentContact.getAttribute(Attributes.EMAIL));
        phoneField.setText(currentContact.getAttribute(Attributes.PHONE_NUMBER));

        if (getTypeOf(currentContact) == ContactType.COMPANY) {
            isCompanyCheckBox.setSelected(true);
            companyFieldContainer.setVisible(true);
            companyFieldContainer.setManaged(true);
            companyField.setText(currentContact.getAttribute(Attributes.COMPANY_NAME));
        } else {
            isCompanyCheckBox.setSelected(false);
            companyFieldContainer.setVisible(false);
        }
    }

    private ContactType getTypeOf(Contact contact) {
        if (contact instanceof PersonalContact) {
            return ((PersonalContact) contact).getType();
        }
        if (contact instanceof CompanyContact) {
            return ((CompanyContact) contact).getType();
        }
        return null;
    }

    @FXML
    private synchronized void removeContact(ActionEvent event) {
        if (currentContact == null) {
            showAlert(Alert.AlertType.WARNING, "Eliminar Contacto", "No hay contacto seleccionado para eliminar.");
            return;
        }

        try {
            LinkedListCustom<Contact> allContacts = contactManager.getAllContacts();
            System.out.println(currentContact);
            allContacts.remove(currentContact);
            nextContact();
            showAlert(Alert.AlertType.INFORMATION, "Eliminar Contacto", "El contacto fue eliminado con éxito.");

            switchToPrimaryView(event);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo eliminar el contacto: " + e.getMessage());
            System.out.println(e);
        }
    }

    @FXML
    private synchronized void saveContact(ActionEvent event) {
        try {
            String name = nameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            boolean isCompany = isCompanyCheckBox.isSelected();
            String company = isCompany ? companyField.getText().trim() : "";

            if (name.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Por favor, complete los campos obligatorios: Nombre, Apellido y Teléfono.");
                return;
            }

            Contact newContact;
            if (isCompany) {
                CompanyContactCreator companyCreator = new CompanyContactCreator();
                newContact = companyCreator.createContact(name, lastName, phone, email, "", company);
            } else {
                PersonalContactCreator personalCreator = new PersonalContactCreator();
                newContact = personalCreator.createContact(name, lastName, phone, email);
            }

            LinkedListCustom<Contact> allContacts = contactManager.getAllContacts();

            int currentIndex = allContacts.indexOf(currentContact);

            if (currentIndex != -1) {
                allContacts.set(currentIndex, newContact);
                contactManager.setCurrentSelectedContact(newContact);
                showAlert(Alert.AlertType.INFORMATION, "Éxito", "El contacto ha sido actualizado exitosamente.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "No se pudo encontrar el contacto para actualizar.");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Ocurrió un error al guardar el contacto: " + e.getMessage());
        }
    }
}

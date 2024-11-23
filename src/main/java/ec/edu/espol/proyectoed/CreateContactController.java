package ec.edu.espol.proyectoed;

import static ec.edu.espol.proyectoed.PrimaryController.showAlert;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactManager;
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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class CreateContactController implements Initializable {

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
    private Button saveButton;
    @FXML
    private VBox additionalAttributsContainer;
    /**
     * Initializes the controller class.
     */
    private final ContactManager contactManager = ContactManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void switchToAddContactController(ActionEvent event) {
    }

    @FXML
    private void loadContactImage(ActionEvent event) {
    }

    @FXML
    private void toggleCompanyField(ActionEvent event) {
        boolean isVisible = companyFieldContainer.isVisible();
        companyFieldContainer.setVisible(!isVisible);
        companyFieldContainer.setManaged(!isVisible);
    }

    @FXML
    private void switchToPrmiaryView(ActionEvent event) {
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cambiar la vista: " + e.getMessage());
        }
    }

    //3)Funcionalidad para crear nuevos contactos
    @FXML
    private void saveContact(ActionEvent event) {
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
                newContact = companyCreator.createContact(name, lastName, phone, email, company);
            } else {
                PersonalContactCreator personalCreator = new PersonalContactCreator();
                newContact = personalCreator.createContact(name, lastName, phone, email);
            }

            contactManager.addContact(newContact);
            showAlert(Alert.AlertType.INFORMATION, "Éxito", "El contacto ha sido guardado exitosamente.");

            clearForm();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Ocurrió un error al guardar el contacto: " + e.getMessage());
        }
    }

    private void clearForm() {
        nameField.clear();
        lastNameField.clear();
        phoneField.clear();
        emailField.clear();
        companyField.clear();
        isCompanyCheckBox.setSelected(false);
        companyFieldContainer.setVisible(false);
        companyFieldContainer.setManaged(false);
    }
}

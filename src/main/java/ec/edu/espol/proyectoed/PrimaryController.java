package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactManager;
import ec.edu.espol.proyectoed.model.creators.CompanyContactCreator;
import ec.edu.espol.proyectoed.model.creators.PersonalContactCreator;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable{
    private final ContactManager contactManager = new ContactManager();
    private final ObservableList<Contact> contactsObservableList = FXCollections.observableArrayList();
    
    @FXML
    private ImageView logo;
    @FXML
    private TableColumn<Contact, String> nameColumn;
    @FXML
    private TableColumn<Contact, String> emailColumn;
    @FXML
    private TableColumn<Contact, String> phoneColumn;
    @FXML
    private TableView<Contact> contactsTable;
    @FXML
    private TableColumn<Contact, String> lastName;
    @FXML
    private TableColumn<Contact, String> companyColumn;
    @FXML
    private ImageView logo1;
    @FXML
    private Button createContactButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configuración inicial del TableView
        nameColumn.setText(Attributes.FIRST_NAME.getDisplayName());
        lastName.setText(Attributes.LAST_NAME.getDisplayName());
        phoneColumn.setText(Attributes.PHONE_NUMBER.getDisplayName());
        emailColumn.setText(Attributes.EMAIL.getDisplayName());
        companyColumn.setText(Attributes.COMPANY_NAME.getDisplayName());
        
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.FIRST_NAME.getDisplayName())));
        lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.LAST_NAME.getDisplayName())));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.PHONE_NUMBER.getDisplayName())));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.EMAIL.getDisplayName())));
        companyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.COMPANY_NAME.getDisplayName())));

        // Creadores de contactos 
        PersonalContactCreator personalCreator = new PersonalContactCreator();
        CompanyContactCreator companyCreator = new CompanyContactCreator();

        Contact USER = personalCreator.createContact("Matías", "Collaguazo","0912345678","matias@example.com");
        Contact personalContact1 = personalCreator.createContact("Pablo","Menéndez","0998765432","pablo@example.com");
        Contact companyContact1 = companyCreator.createContact("Juan","Peréz","0987654321","info@scheel.com","Scheel Constructora");
        Contact companyContact2 = companyCreator.createContact("Carla","Santacruz","0943526478","info@scheel.com","Scheel Constructora");
        Contact personalContact2 = personalCreator.createContact("Santiago","Menéndez","0943565374");
        // Agregar contactos a la lista observable
        setUser(USER);
        contactManager.addContact(personalContact1);
        contactManager.addContact(companyContact1);
        contactManager.addContact(companyContact2);
        contactManager.addContact(personalContact2);

        loadContactsFromManager();
    }
    
    public static void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    private void switchToAddContactController(){
        try {
        // Cargar el FXML
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/ec/edu/espol/proyectoed/addContactDialog.fxml"));
        DialogPane dialogPane = fxmlLoader.load();
        
        // Crear el diálogo
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);
        dialog.setTitle("Agregar Nuevo Contacto");
        
        // Mostrar el diálogo y manejar el resultado
        Optional<ButtonType> clickedButton = dialog.showAndWait();
        if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
            // Obtener el controlador y configurar los eventos
            AddContactController controller = fxmlLoader.getController();
            if(!controller.isInputValid()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Validación");
                alert.setHeaderText("Campos incompletos");
                alert.setContentText("Por favor complete todos los campos obligatorios.");
                alert.showAndWait();
            }else{                
                // Crear el contacto basado en el tipo seleccionado
                Contact newContact;
                if (controller.isPersonalContact()) {
                    PersonalContactCreator creator = new PersonalContactCreator();
                    newContact = creator.createContact(
                        controller.getFirstName(),
                        controller.getLastName(),
                        controller.getPhone(),
                        controller.getEmail()
                    );
                } else {
                    CompanyContactCreator creator = new CompanyContactCreator();
                    newContact = creator.createContact(
                        controller.getFirstName(),
                        controller.getLastName(),
                        controller.getPhone(),
                        controller.getEmail(),
                        controller.getCompany()
                    );
                }
                
                // Agregar el nuevo contacto
                contactManager.addContact(newContact);
                
                // Actualizar la tabla
                loadContactsFromManager();
            }
        }
        } catch (IOException e) {
        showAlert(Alert.AlertType.ERROR, "Error", "Error al cargar el diálogo: " + e.getMessage() + " causado" +e.getCause());
        }
    }
 
    private void setUser(Contact user){
        contactManager.setUser(user);
    }
    
    /*
        Compability feature, added because ArrayCustom isn't compatible with ObservableList<>
        directly, then we achieve the contacts into something compatible with observable list,
        and then... is compatible with TableView (With default ArrayList class is compatible)
    */
    private void loadContactsFromManager() {
        contactsObservableList.clear();
        ArrayCustom<Contact> allContacts = contactManager.getAllContacts();
        System.out.println("Cantidad de contactos es: "+allContacts.getSize());
        System.out.println(contactManager.getAllContacts());
        ObservableList<Contact> observableContacts = FXCollections.observableArrayList();

        for (int i = 0; i < allContacts.getSize(); i++) {
            observableContacts.add(allContacts.get(i));
        }

        contactsObservableList.addAll(observableContacts);
        contactsTable.setItems(contactsObservableList);
    }
    
}
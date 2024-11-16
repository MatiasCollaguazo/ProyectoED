package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.ContactManager;
import ec.edu.espol.proyectoed.model.PersonalContact;
import ec.edu.espol.proyectoed.model.creators.CompanyContactCreator;
import ec.edu.espol.proyectoed.model.creators.PersonalContactCreator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable{

    @FXML
    private ImageView logo;
    @FXML
    private TableColumn<Contact, String> nameColumn;
    @FXML
    private TableColumn<Contact, String> emailColumn;
    @FXML
    private TableColumn<Contact, String> phoneColumn;
    @FXML
    private TableColumn<Contact, String> jobColumn;
    
    @FXML
    private TableView<Contact> contactsTable;
    private final ContactManager contactManager = new ContactManager();
    private final ObservableList<Contact> contactsObservableList = FXCollections.observableArrayList();

    
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configuración de columnas
        nameColumn.setCellValueFactory(new PropertyValueFactory<>(Attributes.NAME.getDisplayName()));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>(Attributes.EMAIL.getDisplayName()));
        phoneColumn.setCellValueFactory(cellData -> {
            String phoneNumber = null;
            for (ContactAttribute<String, String> attribute : cellData.getValue().getMainAttributes()) {
                if (attribute.getAttributeName().equals(Attributes.PHONE_NUMBER.name())) {
                    phoneNumber = attribute.getValue();
                    break;
                }
            }
            return new javafx.beans.property.SimpleStringProperty(phoneNumber);
        });
        


        contactsTable.setItems(contactsObservableList);

        PersonalContactCreator personalCreator = new PersonalContactCreator();
        CompanyContactCreator companyCreator = new CompanyContactCreator();

        PersonalContact user = (PersonalContact) personalCreator.createContact("Matías", "Collaguazo", "0999999999", "matias@example.com");
        setUser(user);

        Contact contact1 = personalCreator.createContact("Pablo", "Toledo", "0943526475", "pablo@example.com");
        Contact contact2 = companyCreator.createContact("Juan", "TechCorp", "0988888888", "juan@techcorp.com");

        contactManager.addContact(contact1);
        contactManager.addContact(contact2);

        loadContactsFromManager();
    }

    
    private void setUser(Contact user){
        contactManager.setUser(user);
    }
    
    private void loadContactsFromManager() {
        ArrayCustom<Contact> allContacts = contactManager.getAllContacts();
        for (int i = 0; i < allContacts.getSize(); i++) {
            contactsObservableList.add(allContacts.get(i));
        }
    }
    
}
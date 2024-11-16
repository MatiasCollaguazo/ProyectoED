package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Attributes;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactAttribute;
import ec.edu.espol.proyectoed.model.ContactManager;
import ec.edu.espol.proyectoed.model.ContactType;
import ec.edu.espol.proyectoed.model.PersonalContact;
import ec.edu.espol.proyectoed.model.creators.CompanyContactCreator;
import ec.edu.espol.proyectoed.model.creators.ContactCreator;
import ec.edu.espol.proyectoed.model.creators.PersonalContactCreator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
        // Configuración inicial del TableView
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.FIRST_NAME.getDisplayName())));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.PHONE_NUMBER.getDisplayName())));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAttribute(Attributes.EMAIL.getDisplayName())));

        // Creadores de contactos
        PersonalContactCreator personalCreator = new PersonalContactCreator();
        CompanyContactCreator companyCreator = new CompanyContactCreator();

        Contact USER = personalCreator.createContact("Matías", "Collaguazo","0912345678","matias@example.com");
        Contact pabloContact = personalCreator.createContact("Pablo","Menéndez","0998765432","pablo@example.com");
        Contact companyContact = companyCreator.createContact("Juan Pérez","Constructora Scheel","0987654321","info@scheel.com");

        
        // Agregar contactos a la lista observable
        setUser(USER);
        contactManager.addContact(pabloContact);
        contactManager.addContact(companyContact);
        loadContactsFromManager();
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
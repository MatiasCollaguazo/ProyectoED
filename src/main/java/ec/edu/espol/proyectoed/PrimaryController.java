package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.ArrayCustom;
import ec.edu.espol.proyectoed.model.Contact;
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
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        jobColumn.setCellValueFactory(new PropertyValueFactory<>("job"));

        PersonalContactCreator personalCreator = new PersonalContactCreator();
        CompanyContactCreator companyCreator = new CompanyContactCreator();

        PersonalContact user = (PersonalContact) personalCreator.createContact("Matías", "Collaguazo", "0999999999", "matias@example.com");
        setUser(user);

        contactManager.addContact(personalCreator.createContact("Pablo", "Toledo", "0943526475", "pablo@example.com"));
        contactManager.addContact(companyCreator.createContact("Juan", "TechCorp", "0988888888", "juan@techcorp.com"));
        
        
    }
    
    private void setUser(Contact user){
        contactManager.setUser(user);
    }
}
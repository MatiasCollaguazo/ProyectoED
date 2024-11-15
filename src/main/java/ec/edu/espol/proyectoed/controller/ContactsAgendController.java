package ec.edu.espol.proyectoed.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ContactsAgendController implements Initializable {

    @FXML
    private ListView<?> contactListView;
    @FXML
    private Label totalContactsLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private ListView<?> attributesListView;
    @FXML
    private ImageView photoImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePreviousContact(ActionEvent event) {
    }

    @FXML
    private void handleNextContact(ActionEvent event) {
    }

    @FXML
    private void handleCreateContact(ActionEvent event) {
    }

    @FXML
    private void handleEditContact(ActionEvent event) {
    }

    @FXML
    private void handleDeleteContact(ActionEvent event) {
    }

    @FXML
    private void handleFilterContacts(ActionEvent event) {
    }

    @FXML
    private void handleSortContacts(ActionEvent event) {
    }
    
}

package ec.edu.espol.proyectoed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author matia
 */
public class ViewContactController implements Initializable {

    @FXML
    private Button addPhotoButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button saveButton;
    @FXML
    private CheckBox isCompanyCheckBox;
    @FXML
    private HBox companyFieldContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void toggleCompanyField() {
        boolean isVisible = companyFieldContainer.isVisible();
        companyFieldContainer.setVisible(!isVisible);
        companyFieldContainer.setManaged(!isVisible);
    }

    
}

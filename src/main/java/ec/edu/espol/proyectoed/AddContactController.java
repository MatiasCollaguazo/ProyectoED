package ec.edu.espol.proyectoed;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author FranciscoAve
 */

public class AddContactController{
    
    @FXML
    private TextField firstNameField;
    
    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField phoneField;
    
    @FXML
    private TextField emailField;

    @FXML
    private TextField companyField;
    
    @FXML
    private RadioButton personalRadio;
    
    
    public String getFirstName() {
        return firstNameField.getText();
    }
    
    public String getLastName() {
        return lastNameField.getText();
    }
    
    public String getPhone() {
        return phoneField.getText();
    }
    
    public String getEmail() {
        return emailField.getText();
    }
    
    public String getCompany() {
        return companyField.getText();
    }
    
    public boolean isPersonalContact() {
        return personalRadio.isSelected();
    }
    
    public boolean isInputValid() {
        if (firstNameField.getText().isEmpty() || 
            phoneField.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    
    
}

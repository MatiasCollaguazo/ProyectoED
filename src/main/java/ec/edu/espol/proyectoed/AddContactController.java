/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed;
import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.ContactManager;
import ec.edu.espol.proyectoed.model.creators.CompanyContactCreator;
import ec.edu.espol.proyectoed.model.creators.PersonalContactCreator;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Gabriela
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
    
    // Método para validar la entrada
    public boolean isInputValid() {
        if (firstNameField.getText().isEmpty() || 
            lastNameField.getText().isEmpty() || 
            phoneField.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    
    
}

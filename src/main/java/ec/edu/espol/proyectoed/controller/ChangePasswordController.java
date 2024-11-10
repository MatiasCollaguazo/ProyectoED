package ec.edu.espol.proyectoed.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Matías_Collaguazo
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private PasswordField antiquePassword;
    @FXML
    private PasswordField newPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changePassword(MouseEvent event) {
    }

    
}

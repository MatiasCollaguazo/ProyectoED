/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author FranciscoAve
 */
public class SearchDialogController implements Initializable{
    @FXML
    private ComboBox<String> searchCriteriaComboBox;
    @FXML
    private TextField searchTermField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar las opciones de búsqueda
        searchCriteriaComboBox.getItems().addAll(
            "Nombre",
            "Apellido",
            "Teléfono",
            "Tipo de Contacto (Personal/Empresa)"
        );
        searchCriteriaComboBox.getSelectionModel().selectFirst();
    }
    
    public String getSearchCriteria() {
        return searchCriteriaComboBox.getValue();
    }
    
    public String getSearchTerm() {
        return searchTermField.getText();
    }
    
    public boolean isInputValid() {
        return !searchTermField.getText().trim().isEmpty() && 
               searchCriteriaComboBox.getValue() != null;
    }
}

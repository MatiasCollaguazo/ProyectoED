module ec.edu.espol.proyectoed {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyectoed to javafx.fxml;
    exports ec.edu.espol.proyectoed;
    requires com.google.gson;
}

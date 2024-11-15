module ec.edu.espol.proyectoed {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyectoed to javafx.fxml;
    opens ec.edu.espol.proyectoed.model to com.google.gson;
    exports ec.edu.espol.proyectoed;
    requires com.google.gson;
    requires java.base;
}

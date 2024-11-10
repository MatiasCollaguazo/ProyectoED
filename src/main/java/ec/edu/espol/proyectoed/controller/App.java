package ec.edu.espol.proyectoed.controller;

import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.FirebaseDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        /*
            //Add user___________________________________________
                // Crear una instancia de Usuario
                Contact user = new Contact("Matías", "Collaguazo", "0987654321", "matiascoll07@hotmail.com");

                // Obtener la instancia única de FirebaseDatabase y guardar el usuario
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                db.saveData("users", user.toJson());

                System.out.println("Usuario guardado en la base de datos.");
            //_____________________________________________
        */
        
        /*Delete user
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            db.deleteData("users");
        
        */
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
package ec.edu.espol.proyectoed;

import ec.edu.espol.proyectoed.model.Contact;
import ec.edu.espol.proyectoed.model.FirebaseDatabase;
import ec.edu.espol.proyectoed.model.PersonalContact;
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
                PersonalContact user = new PersonalContact("Matías", "Collaguazo", "0987654321", "mcollagu@espol.edu.ec");

                // Obtener la instancia única de FirebaseDatabase y guardar el usuario
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                db.saveData("users", user.toJson());

                System.out.println("Usuario guardado en la base de datos.");
            //_____________________________________________
        */
        
        /*Delete collection
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            db.deleteData("users");
        
        */
        
        
        /*Delete user
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            db.deleteData("users/");
        */
        
        /*Obtain data
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            String data = db.getData("users");
            System.out.println(data);
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
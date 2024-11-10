package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public interface Database {
    void saveData(String path, String data);
    String getData(String path);
    void updateData(String path, String data);
    void deleteData(String path);
}

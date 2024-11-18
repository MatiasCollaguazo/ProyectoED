package ec.edu.espol.proyectoed.model;

/**
 *
 * @author matia
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

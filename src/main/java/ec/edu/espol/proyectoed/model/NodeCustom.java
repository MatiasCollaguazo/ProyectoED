package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class NodeCustom<E> {

    E data;
    NodeCustom<E> next;
    NodeCustom<E> prev;

    public NodeCustom(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeCustom<E> getNext() {
        return next;
    }

    public void setNext(NodeCustom next) {
        this.next = next;
    }

    public NodeCustom<E> getPrev() {
        return prev;
    }

    public void setPrev(NodeCustom prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
}

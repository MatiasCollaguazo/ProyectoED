package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class ContactAttribute<K, V> {

    private K attributeName;
    private V value;

    public ContactAttribute(K attributeName, V value) {
        this.attributeName = attributeName;
        this.value = value;
    }

    public K getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(K attributeName) {
        this.attributeName = attributeName;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Attribute{");
        sb.append("attributeName=").append(attributeName);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

}

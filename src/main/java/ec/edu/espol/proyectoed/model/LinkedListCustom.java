package ec.edu.espol.proyectoed.model;

/**
 * 
 * @author Matías_Collaguazo
 */
public class LinkedListCustom<E> {
    private NodeCustom<E> head;
    private NodeCustom<E> last;
    private int selfSize;

    public LinkedListCustom() {
        head = null;
        last = null;
        selfSize = 0;
    }

    public NodeCustom<E> getHead() throws Exception {
        if (head == null) {
            throw new Exception("The linked list is empty...");
        }
        return head;
    }

    public NodeCustom<E> getLast() throws Exception {
        if (last == null) {
            throw new Exception("The linked list is empty...");
        }
        return last;
    }

    public int getSize() {
        return selfSize;
    }

    public void add(E data) {
        NodeCustom<E> newNode = new NodeCustom<>(data);
        if (head == null) {
            head = newNode;
            last = newNode;
            head.setNext(head);
            head.setPrev(head);
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
            newNode.setNext(head);
            head.setPrev(newNode);
            last = newNode;
        }
        selfSize++;
    }

    public E get(int i) {
        if (i < 1 || i > selfSize) {
            throw new IndexOutOfBoundsException("Index out of bounds...");
        }
        NodeCustom<E> current = head;
        for (int index = 1; index < i; index++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void add(int i, E data) {
        if (i < 1 || i > selfSize + 1) {
            throw new IndexOutOfBoundsException("Index out of bounds...");
        }

        NodeCustom<E> newNode = new NodeCustom<>(data);
        if (i == 1) {
            newNode.setNext(head);
            newNode.setPrev(last);
            last.setNext(newNode);
            head.setPrev(newNode);
            head = newNode;
            if (last == null) {
                last = newNode;
            }
        } else {
            NodeCustom<E> current = head;
            for (int index = 1; index < i - 1; index++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            if (newNode.getNext() == head) {
                last = newNode;
            }
        }
        selfSize++;
    }

    public void remove(int i) {
        if (i < 1 || i > selfSize) {
            throw new IndexOutOfBoundsException("Index out of bounds...");
        }
        if (i == 1) {
            if (head == last) {
                head = null;
                last = null;
            } else {
                head = head.getNext();
                head.setPrev(last);
                last.setNext(head);
            }
        } else {
            NodeCustom<E> current = head;
            for (int index = 1; index < i; index++) {
                current = current.getNext();
            }
            NodeCustom<E> prevNode = current.getPrev();
            NodeCustom<E> nextNode = current.getNext();

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);

            if (current == last) {
                last = prevNode;
            }
        }
        selfSize--;
    }

    public void removeLast() throws Exception {
        if (last == null) {
            throw new Exception("The linked list is empty...");
        }
        if (head == last) {
            head = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(head);
            head.setPrev(last);
        }
        selfSize--;
    }

    @Override
    public String toString() {
        StringBuilder textToBuild = new StringBuilder();
        textToBuild.append("[");

        NodeCustom<E> current = head;
        if (head != null) {
            do {
                textToBuild.append(current.getData());
                if (current.getNext() != head) {
                    textToBuild.append(" | ");
                }
                current = current.getNext();
            } while (current != head);
        }

        textToBuild.append("]");
        return textToBuild.toString();
    }
}

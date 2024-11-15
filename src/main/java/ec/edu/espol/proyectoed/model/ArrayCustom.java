package ec.edu.espol.proyectoed.model;

import java.util.ArrayList;

/**
 *
 * @author Matías_Collaguazo
 */
public class ArrayCustom<E> {

    private int selfSize = 0;
    private E[] array;

    public ArrayCustom() {
        array = (E[]) new Object[2];
    }

    public void add(E element) {
        if (selfSize == array.length) {
            expandCapacity();
        }
        array[selfSize++] = element;
    }

    public void add(int index, E e) {
        if (index < 0 || index > selfSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (selfSize == array.length) {
            expandCapacity();
        }
        System.arraycopy(array, index, array, index + 1, selfSize - index);
        array[index] = e;
        selfSize++;
    }

    public void remove(int index) {
        if (index < 0 || index >= selfSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int numMoved = selfSize - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--selfSize] = null; // Elimina referencia
    }

    private void expandCapacity() {
        int newCapacity = array.length + (array.length / 2);
        E[] newArr = (E[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArr, 0, selfSize);
        array = newArr;
    }

    public E get(int index) {
        if (index < 0 || index >= selfSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder textToBuild = new StringBuilder("[");
        for (int i = 0; i < selfSize; i++) {
            textToBuild.append(array[i]);
            if (i < selfSize - 1) {
                textToBuild.append(", ");
            }
        }
        textToBuild.append("]");
        return textToBuild.toString();
    }

    public int getSize() {
        return selfSize;
    }
}

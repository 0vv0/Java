package lesson8.task1;

import java.util.Iterator;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class DynamicArray<E> implements Stack {
    private int size = 0;
    private E[] value = (E[]) new Object[size];

    private void reSize(int newSize) {
        E[] temp = (E[]) new Object[newSize];
        for (int i = 0; i < newSize; i++) {
            temp[i] = i < size ? value[i] : null;
        }
        size = newSize;
        value = (E[]) new Object[size];
        System.arraycopy(temp, 0, value, 0, size);
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public void pool(Object element) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return null;
    }

}

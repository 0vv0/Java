package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/16/2017.
 */
@SuppressWarnings("unchecked")
public abstract class DynamicArray<T> implements DynamicStructure<T> {
    protected T[] list = (T[]) new Object[0];

    @Override
    public T pop() {
        T element = peek();
        T[] newList = (T[]) new Object[list.length - 1];
        System.arraycopy(list, 1, newList, 0, newList.length);
        list = newList;
        return element;
    }

    @Override
    public T peek() {
        if (list.length == 0) {
            throw new NoSuchElementException("Dynamic array is empty");
        }
        return list[0];
    }

    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Dynamic array is empty");
                }
                return list[index++];
            }
        };
    }
}

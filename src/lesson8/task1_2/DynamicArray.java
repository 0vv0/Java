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
    public boolean isEmpty() {
        return list.length == 0;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean contains(T element) {
        for (T elem : list) {
            if (elem.equals(element)) {
                return true;
            }
        }
        return false;
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

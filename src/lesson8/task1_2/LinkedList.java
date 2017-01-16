package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/16/2017.
 */
public abstract class LinkedList<T> implements DynamicStructure<T> {
    protected java.util.LinkedList<T> list = new java.util.LinkedList<>();

    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Linked list is empty");
        }
        return list.peek();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<T> iterator = list.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return iterator.next();
                } else {
                    throw new NoSuchElementException("Linked list is empty");
                }
            }
        };
    }
}

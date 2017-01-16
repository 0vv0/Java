package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/16/2017.
 */
public abstract class ConnectedList<T> implements DynamicStructure<T> {
    protected Node<T> head;

    @Override
    public T pop() {
        T element = peek();
        head = head.getNext();
        return element;
    }

    @Override
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Connected list is empty");
        }
        return head.getValue();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> element = head;
        while (element != null) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Connected list is empty");
                }
                T element = cursor.getValue();
                cursor = cursor.getNext();
                return element;
            }
        };
    }
}

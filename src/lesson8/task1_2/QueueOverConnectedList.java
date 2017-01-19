package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class QueueOverConnectedList<T> extends ConnectedList<T> {
    @Override
    public ConnectedList<T> push(T element) {
        if (head == null) {
            head = new Node<>(element);
            return this;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<>(element));
        return this;
    }
}

package lesson8.task1_2;

import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class QueueOverConnectedList<T> extends ConnectedList<T> implements Queue<T> {

    @Override
    public void offer(T t) {
        if (tail == null) {
            tail = new Node<T>(t);
            head = tail;
            return;
        }
        Node<T> node = new Node<T>(t);
        node.setPrevious(tail);
        tail.setNext(node);
        tail = node;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    @Override
    public T remove() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return poll();
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        }
        T elem = peek();
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        return elem;
    }

    @Override
    public T element() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return peek();
    }
}

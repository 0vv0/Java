package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverConnectedList<E> implements Stack<E> {
    private Node<E> head;

    @Override
    public E pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E element = head.getValue();
        head = head.getNext();
        return element;
    }

    @Override
    public E peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    @Override
    public Stack<E> push(E element) {
        Node<E> elem = new Node<>(element);
        elem.setNext(head);
        head = elem;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node<E> element = head;
        while (element.getNext() != null) {
            count++;
            element = element.getNext();
        }
        return count;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new StackOverConnectedListIterator<>();
    }

    private class StackOverConnectedListIterator<T> implements Iterator<T> {
        Node<T> current = (Node<T>) head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T element = current.getValue();
            current = current.getNext();
            return element;
        }
    }
}

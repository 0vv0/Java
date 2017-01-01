package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class QueueOverConnectedList<T> implements Queue<T> {
    private Node<T> head;

    @Override
    public Queue<T> push(T element) {
        if(head==null){head = new Node<>(element);return this;}
        Node<T> current = head;
        while(current.getNext()!=null){current = current.getNext();}
        current.setNext(new Node<>(element));
        return this;
    }

    @Override
    public T pop() {
        if(head==null){throw new NoSuchElementException();}
        T element = head.getValue();
        head = head.getNext();
        return element;
    }

    @Override
    public T peek() {
        if(head==null){throw new NoSuchElementException();}
        return head.getValue();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Object o : this) {
            size++;
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueOcerConnectedListIterator<>();
    }

    private class QueueOcerConnectedListIterator<E> implements Iterator<E> {
        private Node<E> current = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.getValue();
            current = current.getNext();
            return element;
        }
    }
}

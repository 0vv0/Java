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
        T element = peek();
        head = head.getNext();
        return element;
    }

    @Override
    public T peek() {
        if(head==null){throw new NoSuchElementException("Queue is empty");}
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
        return new QueueOcerConnectedListIterator();
    }

    private class QueueOcerConnectedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T element = current.getValue();
            current = current.getNext();
            return element;
        }
    }
}

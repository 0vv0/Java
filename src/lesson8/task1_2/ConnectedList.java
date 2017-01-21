package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/16/2017.
 */
public abstract class ConnectedList<T> implements DynamicStructure<T> {
    protected Node<T> head;
    protected Node<T> tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> cursor = head;
        while (cursor != null) {
            count++;
            cursor = cursor.getNext();
        }
        return count;
    }

    @Override
    public boolean contains(T element) {
        Node<T> cursor = head;
        while (cursor != null) {
            if (cursor.getValue().equals(element)) {
                return true;
            }
            cursor = cursor.getNext();
        }
        return false;
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

    protected static class Node<T> {
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T element) {
            this.data = element;
        }

        T getValue() {
            return data;
        }

        Node<T> getNext() {
            return next;
        }

        Node<T> setNext(Node<T> next) {
            this.next = next;
            return this;
        }

        Node<T> getPrevious() {
            return previous;
        }

        Node<T> setPrevious(Node<T> next) {
            this.previous = previous;
            return this;
        }
    }
}



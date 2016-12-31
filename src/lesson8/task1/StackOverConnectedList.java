package lesson8.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverConnectedList<E> implements Stack<E> {
    private Inner<E> head;

    @Override
    public E pop() {
        if(head==null){throw new NoSuchElementException();}
        E element = head.getValue();
        head = head.getNext();
        return element;
    }

    @Override
    public E peek() {
        if(head==null){throw new NoSuchElementException();}
        return head.getValue();
    }

    @Override
    public Stack<E> push(E element) {
        Inner<E> elem = new Inner<>(element);
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
        Inner<E> element = head;
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

    private class StackOverConnectedListIterator<E> implements Iterator<E> {
        Inner<E> current = (Inner<E>) head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(current==null){throw new NoSuchElementException();}
            E element = current.getValue();
            current = current.getNext();
            return element;
        }
    }

    private class Inner<E> {
        private E element;
        private Inner<E> next;

        Inner(E element) {
            this.element = element;
            this.next = null;
        }

        E getValue() {
            return element;
        }

        Inner<E> getNext() {
            return next;
        }

        Inner<E> setNext(Inner<E> next) {
            this.next = next;
            return this;
        }

    }


}

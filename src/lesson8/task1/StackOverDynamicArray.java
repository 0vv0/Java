package lesson8.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverDynamicArray<E> implements Stack<E> {
    private int size = 0;
    @SuppressWarnings("unchecked")
    private E[] value = (E[]) new Object[size];

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        E obj = value[0];
        size--;
        if (size == 0) {
            value = (E[]) new Object[size];
        } else {
            E[] temp = (E[]) new Object[size];
            System.arraycopy(value, 1, temp, 0, size);
            value = temp;
        }
        return obj;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return value[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public StackOverDynamicArray<E> pool(E element) {
        if(size==Integer.MAX_VALUE){throw new StackOverflowError("size>Integer.MAX_VALUE");}
        E[] temp = (E[]) new Object[size+1];
        System.arraycopy(value, 0, temp, 1, size);
        value = temp;
        value[0]=element;
        size++;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new StackOverDynamicArrayIterator();
    }

    private class StackOverDynamicArrayIterator implements Iterator<E>{

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return size>0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            return pop();
        }

        @Override
        public void  remove(){
            pop();
        }


    }
}

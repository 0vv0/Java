package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
@SuppressWarnings("unchecked")
public class StackOverDynamicArray<T> implements Stack<T> {
    private T[] list = (T[]) new Object[0];

    @Override
    public T pop() {
        if (list.length == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        T obj = list[0];
        T[] temp = (T[]) new Object[list.length - 1];
        System.arraycopy(list, 1, temp, 0, temp.length);
        list = temp;
        return obj;
    }

    @Override
    public T peek() {
        if (list.length == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list[0];
    }

    @Override
    public StackOverDynamicArray<T> push(T element) {
        if (list.length == Integer.MAX_VALUE) {
            throw new StackOverflowError("size>Integer.MAX_list");
        }
        T[] temp = (T[]) new Object[list.length + 1];
        System.arraycopy(list, 0, temp, 1, list.length);
        list = temp;
        list[0] = element;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackOverDynamicArrayIterator();
    }

    private class StackOverDynamicArrayIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.length;
        }

        @Override
        public T next() {
            return pop();
        }
    }
}

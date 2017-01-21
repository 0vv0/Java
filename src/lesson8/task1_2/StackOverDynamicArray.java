package lesson8.task1_2;

import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverDynamicArray<T> extends DynamicArray<T> implements Stack<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void push(T elem) {
        T[] arr = (T[]) new Object[list.length + 1];
        System.arraycopy(list, 0, arr, 0, list.length);
        list = arr;
        list[list.length - 1] = elem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        T elem = peek();
        T[] arr = (T[]) new Object[list.length - 1];
        System.arraycopy(list, 0, arr, 0, list.length - 1);
        list = arr;
        return elem;
    }

    @Override
    public T peek() {
        if (list.length == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list[list.length - 1];
    }
}

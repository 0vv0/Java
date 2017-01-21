package lesson8.task1_2;

import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public final class QueueOverDynamicArray<T> extends DynamicArray<T> implements Queue<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void offer(T t) {
        T[] arr = (T[]) new Object[list.length + 1];
        System.arraycopy(list, 0, arr, 0, list.length);
        list = arr;
        list[list.length - 1] = t;
    }

    @Override
    public T remove() {
        if (list.length == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return poll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if (list.length == 0) {
            return null;
        }
        T elem = list[0];
        T[] arr = (T[]) new Object[list.length - 1];
        System.arraycopy(list, 1, arr, 0, list.length - 1);
        list = arr;
        return elem;
    }

    @Override
    public T element() {
        if (list.length == 0) {
            throw new NoSuchElementException("Dynamic array is empty");
        }
        return peek();
    }

    @Override
    public T peek() {
        return list.length == 0 ? null : list[0];
    }
}

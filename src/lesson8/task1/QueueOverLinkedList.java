package lesson8.task1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class QueueOverLinkedList<T> implements Queue<T> {
    private LinkedList<T> list = new LinkedList<T>();
    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        return list.peek();
    }

    @Override
    public Stack<T> push(T element) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

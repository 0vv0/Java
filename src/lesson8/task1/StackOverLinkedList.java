package lesson8.task1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverLinkedList<T> implements Stack<T>{
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
        list.addLast(element);
        return this;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

package lesson8.task1_2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class QueueOverLinkedList<T> implements Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        if(this.isEmpty()){throw new NoSuchElementException();}
        return list.peek();
    }

    @Override
    public Queue<T> push(T element) {
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

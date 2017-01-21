package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class QueueOverLinkedList<T> extends LinkedList<T> implements Queue<T> {

    @Override
    public void offer(T t) {
        list.offer(t);
    }

    @Override
    public T remove() {
        return list.remove();
    }

    @Override
    public T poll() {
        return list.poll();
    }

    @Override
    public T element() {
        return list.element();
    }

    @Override
    public T peek() {
        return list.peekFirst();
    }
}

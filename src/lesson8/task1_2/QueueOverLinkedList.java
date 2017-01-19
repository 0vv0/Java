package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class QueueOverLinkedList<T> extends LinkedList<T> {
    @Override
    public LinkedList<T> push(T element) {
        list.addLast(element);
        return this;
    }
}

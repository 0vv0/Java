package lesson8.task1_2;


/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverLinkedList<T> extends LinkedList<T> {
    @Override
    public LinkedList<T> push(T element) {
        list.addFirst(element);
        return this;
    }
}

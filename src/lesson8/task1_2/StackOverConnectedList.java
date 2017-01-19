package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverConnectedList<E> extends ConnectedList<E> {
    @Override
    public ConnectedList<E> push(E element) {
        Node<E> elem = new Node<>(element);
        elem.setNext(head);
        head = elem;
        return this;
    }
}

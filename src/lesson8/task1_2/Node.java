package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class Node<T> {
    private final T data;
    private Node<T> next;

    Node(T element) {
        this.data = element;
        this.next = null;
    }

    T getValue() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

}

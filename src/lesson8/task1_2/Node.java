package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
class Node<T> {
    private T element;
    private Node<T> next;

    Node(T element) {
        this.element = element;
        this.next = null;
    }

    T getValue() {
        return element;
    }

    Node<T> getNext() {
        return next;
    }

    Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

}

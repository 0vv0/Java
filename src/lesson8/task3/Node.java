package lesson8.task3;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
class Node<T> {
    private Node<T> previous;
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

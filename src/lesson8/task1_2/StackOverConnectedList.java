package lesson8.task1_2;

import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverConnectedList<E> extends ConnectedList<E> implements Stack<E> {

    @Override
    public void push(E elem) {
        if (head == null) {
            head = new Node<E>(elem);
            tail = head;
            return;
        }
        Node<E> node = new Node<E>(elem);
        node.setNext(head);
        head.setPrevious(node);
        head = node;
    }

    @Override
    public E pop() {
        E elem = peek();
        head = head.getNext();
        return elem;
    }


    @Override
    public E peek() {
        if (head == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        return head.getValue();
    }

}

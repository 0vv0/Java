package lesson8.task1_2;


/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverLinkedList<T> extends LinkedList<T> implements Stack<T> {

    @Override
    public void push(T elem) {
        list.push(elem);
    }

    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        return list.peekLast();
    }
}

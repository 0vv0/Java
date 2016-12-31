package lesson8.task1;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public interface Stack<E> extends Iterable<E>{
    E pop();
    E peek();
    void pool(E element);
    boolean isEmpty();
    int size();
}

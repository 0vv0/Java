package lesson8.task1;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public interface Queue<T> extends Iterable<T>{
    T pop();
    T peek();
    Stack<T> push(T element);
    boolean isEmpty();
    int size();
}

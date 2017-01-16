package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public interface DynamicStructure<T> extends Iterable<T> {
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

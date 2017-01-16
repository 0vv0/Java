package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public interface Stack<T> extends DynamicStructure<T> {
    Stack<T> push(T element);
}

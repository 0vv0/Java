package lesson8.task1_2;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public interface Queue<T> extends DynamicStructure<T> {
    Queue<T> push(T element);
}

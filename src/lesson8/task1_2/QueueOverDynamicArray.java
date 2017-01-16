package lesson8.task1_2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class QueueOverDynamicArray<T> extends DynamicArray<T> {
    @Override
    public QueueOverDynamicArray<T> push(T element) {
        list = Arrays.copyOf(list,list.length+1);
        list[list.length-1] = element;
        return this;
    }
}

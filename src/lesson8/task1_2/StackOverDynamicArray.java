package lesson8.task1_2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Oleksii.Sergiienko on 12/31/2016.
 */
public class StackOverDynamicArray<T> extends DynamicArray<T> {
    @Override
    public StackOverDynamicArray<T> push(T element) {
        list = Arrays.copyOf(list,list.length+1);
        System.arraycopy(list, 0, list, 1, list.length-1);
        list[0] = element;
        return this;
    }
}

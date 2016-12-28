package lesson8.task1;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class DynamicArray<E> implements lesson8.task1.Stack<E>{
    private E[] value;

    public DynamicArray(E... value) {
        this.value = (E[]) new Object[value.length];
    }

    public DynamicArray() {
    }

    @Override
    public void push(E item) {

    }

    @Override
    public E pop() {
        return null;
    }
}

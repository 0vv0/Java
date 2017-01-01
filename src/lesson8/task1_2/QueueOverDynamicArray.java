package lesson8.task1_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
@SuppressWarnings("unchecked")
public class QueueOverDynamicArray<T> implements Queue<T> {
    private T[] list = (T[]) new Object[0];

    @Override
    public T pop() {
        if(list.length==0){throw new NoSuchElementException();}
        T element = list[list.length-1];
        T[] newList = (T[])new Object[list.length-1];
        System.arraycopy(list,0,newList,0,newList.length);
        list = newList;
        return element;
    }

    @Override
    public T peek() {
        if(list.length==0){throw new NoSuchElementException();}
        return list[list.length-1];
    }

    @Override
    public Queue<T> push(T element) {
        T[] newList = (T[])new Object[list.length+1];
        System.arraycopy(list,0,newList,1,list.length);
        list = newList;
        list[0] = element;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return list.length==0;
    }

    @Override
    public int size() {
        return list.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueOverDynamicArrayIterator<>();
    }

    private class QueueOverDynamicArrayIterator<E> implements Iterator<E>{
        private int index = list.length-1;
        @Override
        public boolean hasNext() {
            return index>=0;
        }

        @Override
        public E next() {
            return (E) list[index--];
        }
    }
}

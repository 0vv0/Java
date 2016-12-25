package lesson3.task3;

import lesson3.task2.IArea;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Memory implements IMemory{
    private final String theName;
    private final int theSize;
    private final IMemory.Type theType;

    Memory(String name, IMemory.Type type, int size) {
        if(name==null){throw new IllegalArgumentException("Name is missed");}
        if (size < 0) {
            throw new IllegalArgumentException("Size shouldn't be less then zero");
        }
        this.theName = name;
        this.theSize = size;
        this.theType = type;
    }

    @Override
    public String getName() {
        return theName;
    }

    @Override
    public int getSize() {
        return theSize;
    }

    @Override
    public Type getType() {
        return theType;
    }

}

package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
class Memory implements IMemory{
    private final String theName;
    private final int theSize;
    private final IMemory.Type theType;

    Memory(String name, IMemory.Type type, int size) throws IllegalArgumentException{
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

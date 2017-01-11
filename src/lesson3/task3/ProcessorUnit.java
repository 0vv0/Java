package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
class ProcessorUnit implements IPU {
    private final String name;
    private final IPU.Type theType;

    ProcessorUnit(String name)throws IllegalArgumentException {
        this(name, Type.CPU);
    }

    ProcessorUnit(String name, IPU.Type type) throws IllegalArgumentException{
        if(name==null){throw new IllegalArgumentException("Name is missed");}
        this.name = name;
        this.theType = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return theType;
    }
}

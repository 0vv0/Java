package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class ProcessorUnit implements IPU {
    private final String name;
    private final IPU.Type theType;

    ProcessorUnit(String name) {
        this(name, Type.CPU);
    }

    ProcessorUnit(String name, IPU.Type type) {
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

package lesson3.task2;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Area implements IArea{
    private final String name;
    private final Type type;


    public Area(String name, Type type) {
        if(name==null){throw new IllegalArgumentException("Name is null");}
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }
}

package lesson3.task2;

import org.junit.Test;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
class Area implements IArea {
    private final String name;
    private final Type type;


    Area(String name, Type type) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null");
        }
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        return (o != null
                && o instanceof Area
                && name.equals(((Area) o).getName())
                && type.equals(((Area) o).getType())
        );
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Test
    void testGetType() {
        assert getType().equals(type);
    }

    @Test
    void testGetName() {
        assert getName().equals(name);
    }

    @Test
    void testInstantiation() {
        assert name != null;
        assert type != null;
    }
}

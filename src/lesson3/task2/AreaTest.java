package lesson3.task2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by default on 1/14/2017.
 */
public class AreaTest {
    @Before
    public void setUp() throws Exception {
        try {
            Area area = new Area(null, null);
            assert false : "Generate IllegalArgumentException if name==";
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            Area area = new Area(null, IArea.Type.Ocean);
            assert false : "Generate IllegalArgumentException if name==";
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            Area area = new Area(null, IArea.Type.Island);
            assert false : "Generate IllegalArgumentException if name==";
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            Area area = new Area(null, IArea.Type.Continent);
            assert false : "Generate IllegalArgumentException if name==";
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            Area area = new Area("", IArea.Type.Ocean);
            assert false : "Generate IllegalArgumentException if name==\"\"";
        } catch (IllegalArgumentException e) {
            assert true;
        }
        try {
            Area area = new Area("Area name", IArea.Type.Continent);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getName() throws Exception {
        for (char c = 'A'; c < 'z'; c++) {
            String s = String.valueOf(c);
            Area area = new Area(s, IArea.Type.Continent);
            if (!area.getName().equals(s)) throw new AssertionError();
        }
    }

    @Test
    public void getType() throws Exception {
        for (IArea.Type type : IArea.Type.values()) {
            Area area = new Area("area", type);
            if (!area.getType().equals(type)) throw new AssertionError();
        }
    }

    @Test
    public void equals() throws Exception {
        if (new Area("area", IArea.Type.Ocean).equals(null)) {
            throw new AssertionError(".equals(null)==true");
        }
        if (!new Area("area", IArea.Type.Ocean)
                .equals(new Area("area", IArea.Type.Ocean))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("area", IArea.Type.Ocean)
                .equals(new Area("area", IArea.Type.Continent))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("area", IArea.Type.Ocean)
                .equals(new Area("area", IArea.Type.Island))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("area", IArea.Type.Island)
                .equals(new Area("area", IArea.Type.Continent))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("the Area", IArea.Type.Ocean)
                .equals(new Area("area", IArea.Type.Ocean))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("area", IArea.Type.Ocean)
                .equals("skldfvldk")) {
            throw new AssertionError("equals doesn't work as it should be");
        }
        if (new Area("area", IArea.Type.Ocean)
                .equals((Area) new AreaExtender("areaEx", IArea.Type.Island))) {
            throw new AssertionError("equals doesn't work as it should be");
        }
    }
    class AreaExtender extends Area {
        AreaExtender(String name, Type type) {
            super(name, type);
        }
    }
}
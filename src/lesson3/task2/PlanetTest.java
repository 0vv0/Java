package lesson3.task2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by default on 1/14/2017.
 */
public class PlanetTest {
    private Planet planet;

    @Before
    public void tearsUp() throws Exception {
        try {
            planet = new Planet();
            planet = new Planet("Test planet");
        }catch (Exception e){
            assert false;
        }


        planet.add(
                new Area("Ocean1", IArea.Type.Ocean),
                new Area("Ocean2", IArea.Type.Ocean),
                new Area("Ocean3", IArea.Type.Ocean));
        planet.add(new Area("Ocean1", IArea.Type.Ocean));
        planet.add(new Area("Island1", IArea.Type.Island));
        planet.add(new Area("Island1", IArea.Type.Island));

    }

    @Test
    public void getOceansCount() throws Exception {
        assert planet.getOceansCount() == 3;
    }

    @Test
    public void getContinentsCount() throws Exception {
        assert planet.getContinentsCount() == 0;
    }

    @Test
    public void getIslandsCount() throws Exception {
        assert planet.getIslandsCount() == 1;
    }

    @Test
    public void countAllByType() throws Exception {
        assert planet.countAllByType(IArea.Type.Ocean) == 3;
    }


}
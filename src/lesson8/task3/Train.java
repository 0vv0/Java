package lesson8.task3;

/**
 * Created by Oleksii.Sergiienko on 1/17/2017.
 */
public interface Train{
    Train moveLeft();
    Train moveRight();
    Train lightOn();
    Train lightOff();
    boolean isLightOn();
    boolean isLength(int expectedLength);
}

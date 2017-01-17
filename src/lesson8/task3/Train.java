package lesson8.task3;

/**
 * Created by Oleksii.Sergiienko on 1/17/2017.
 */
public interface Train{
    void moveLeft();
    void moveRight();
    void lightOn();
    void lightOff();
    boolean isLightOn();
    boolean isLength(int expectedLength);
}

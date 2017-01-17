package lesson8.task3;

/**
 * Created by Oleksii.Sergiienko on 1/17/2017.
 */
public interface Carriage {
    void setPrevious(Carriage previous);
    void setNext(Carriage next);
    void setLight(boolean light);
    boolean isLightOn();

    Carriage getPrevious();
    Carriage getNext();
}

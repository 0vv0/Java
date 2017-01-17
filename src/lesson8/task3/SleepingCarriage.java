package lesson8.task3;

/**
 * Created by Oleksii.Sergiienko on 1/17/2017.
 */
public class SleepingCarriage implements Carriage {
    private Carriage previous;
    private boolean light;
    private Carriage next;

    public SleepingCarriage(boolean light) {
        previous = this;
        this.light = light;
        next = this;
    }

    @Override
    public String toString() {
        return (previous==this?">":"<") + light + (next==this?"<":">");
    }

    @Override
    public void setPrevious(Carriage previous) {
        this.previous = previous;
    }

    @Override
    public void setNext(Carriage next) {
        this.next = next;
    }

    @Override
    public void setLight(boolean light) {
        this.light = light;
    }

    @Override
    public boolean isLightOn() {
        return light;
    }

    @Override
    public Carriage getPrevious() {
        return previous;
    }

    @Override
    public Carriage getNext() {
        return next;
    }
}

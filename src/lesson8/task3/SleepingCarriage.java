package lesson8.task3;

import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/17/2017.
 */
public class SleepingCarriage implements Carriage {
    private Carriage previous;
    private boolean light;
    private Carriage next;

    public SleepingCarriage(boolean light) {
//        previous = this;
        this.light = light;
//        next = this;
    }

    @Override
    public String toString() {
        String left = "!", right = "!";
        if (previous != null) {
            left = previous == this ? ">" : "<";
        }
        if (next != null) {
            right = next == this ? "<" : ">";
        }
        return left + light + right;
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

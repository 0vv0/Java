package lesson8.task3;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class BooleanTrain implements Train {
    private static Random random = new Random();
    private Carriage cursor = new SleepingCarriage(random.nextBoolean());
    private int length = 1;

    public int getLength() {
        return length;
    }

    public BooleanTrain(int maxLength) {
        if (maxLength < 1) {
            throw new IllegalArgumentException("one or more carriages");
        }
        this.length = random.nextInt(maxLength)+1;
        maxLength = this.length;
        //Remember the fist Carriage
        Carriage start = cursor;
        while (maxLength-- > 0) {
            cursor.setNext(new SleepingCarriage(random.nextBoolean()));
            cursor.getNext().setPrevious(cursor);
            cursor = cursor.getNext();
        }
        cursor.setNext(start);
        start.setPrevious(cursor);
    }

    public BooleanTrain(){
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("", "[", "]");
        for (int i = 0; i < length; i++) {
            sj.add(cursor.toString());
            cursor = cursor.getNext();
        }
        return sj.toString();
    }

    @Override
    public Train moveLeft() {
        cursor = cursor.getPrevious();
        return this;
    }

    @Override
    public Train moveRight() {
        cursor = cursor.getNext();
        return this;
    }

    @Override
    public Train lightOn() {
        cursor.setLight(true);
        return this;
    }

    @Override
    public Train lightOff() {
        cursor.setLight(false);
        return this;
    }

    @Override
    public boolean isLightOn() {
        return cursor.isLightOn();
    }

    @Override
    public boolean isLength(int expectedLength) {
        return expectedLength == length;
    }
}

package lesson8.task3;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class BooleanTrain implements Train {
    private static Random random = new Random();
    private Carriage cursor;
    private final int length;

    private int getLength() {
        return length;
    }

    public BooleanTrain(final int maxLength) {
        if (maxLength < 1) {
            throw new IllegalArgumentException("one or more carriages");
        }
        cursor = new SleepingCarriage(random.nextBoolean());
        length = random.nextInt(maxLength)+1;

        //Remember the first Carriage
        Carriage start = cursor;
        for(int i=0;i<length-1;i++){
            cursor.setNext(new SleepingCarriage(random.nextBoolean()));
            cursor.getNext().setPrevious(cursor);
            cursor = cursor.getNext();
        }
        cursor.setNext(start);
        start.setPrevious(cursor);
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
    public void moveLeft() {
        cursor = cursor.getPrevious();
//        return this;
    }

    @Override
    public void moveRight() {
        cursor = cursor.getNext();
//        return this;
    }

    @Override
    public void lightOn() {
        cursor.setLight(true);
//        return this;
    }

    @Override
    public void lightOff() {
        cursor.setLight(false);
//        return this;
    }

    @Override
    public boolean isLightOn() {
        return cursor.isLightOn();
    }

    @Override
    public boolean isLength(final int expectedLength) {
        return expectedLength == length;
    }
}

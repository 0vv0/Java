package lesson1.task2;

import java.util.ArrayList;

/**
 *
 * @author Oleksii.Sergiienko
 */
class Rectangles {

    private final ArrayList<Rectangle> rectangles = new ArrayList<>();

    void add(Rectangle one) {
        if (one != null) {
            rectangles.add(one);
        }
    }

    double getArea() {
        double areaSize = 0;

        for (Rectangle rectangle : rectangles) {
            areaSize += rectangle.getArea();
        }
        return areaSize;
    }
}
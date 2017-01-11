package lesson2.task1;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
class Point {
    private final double x;
    private final double y;

    Point() {
        this.x = 0;
        this.y = 0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return String.format("(%5.1f; %5.1f)", x, y);
    }
}

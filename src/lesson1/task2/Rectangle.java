package lesson1.task2;

/**
 *
 * @author Oleksii.Sergiienko
 */
class Rectangle {

    private final double width;
    private final double height;

    Rectangle(double x, double y) {
        if (isSide(x) && isSide(y)) {
            width = x;
            height = y;
        } else {
            throw new IllegalArgumentException("Side is 0 or less: x="
                    + x + ", y=" + y);
        }
    }

    double getPerimeter() {
        return 2 * width + 2 * height;
    }

    double getArea() {
        return width * height;
    }

    private static boolean isSide(double x) {
        return x > 0;
    }
}

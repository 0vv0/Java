package lesson2.task1;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Line {
    private final Point start;
    private final Point end;

    Line() {
        start = new Point();
        end = new Point();
    }

    Line(Point theStartPoint, Point theEndPoint) {
        if (theStartPoint == null || theEndPoint == null) {
            throw new IllegalArgumentException("Start or End point is Null");
        }
        start = theStartPoint;
        end = theEndPoint;
    }

    double getLength() {
        return Math.pow(Math.abs(start.getX() - end.getX()) * Math.abs(start.getX() - end.getX())
                + Math.abs(start.getY() - end.getY()) * Math.abs(start.getY() - end.getY()), 0.5);
    }

    public String toString() {
        return start.toString() + "-" + end.toString();
    }
}

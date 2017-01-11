package lesson2.task1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
class Lines {
    private static final int NUMBER_OF_LINES = 0;
    private final ArrayList<Line> lines = new ArrayList<>();

    Lines(){
        lines.add(new Line());
    }

    void add(Line line) {
        if (line == null) {
            throw new IllegalArgumentException("line is nNull");
        }
        lines.add(line);
    }

    double sumLengths() {
        double sum = 0;
        for (Line l : lines) {
            sum += l.getLength();
        }
        return sum;
    }

    Line longestLine() {
        double max = 0;
        Line line = null;
        for (Line l : lines) {
            if (l.getLength() >= max) {
                max = l.getLength();
                line = l;
            }
        }
        return line;
    }

    public static void main(String[] args) {
        Lines lines = new Lines();
        lines.add(new Line());
        Point[] startPoints = new Point[NUMBER_OF_LINES];
        Point[] endPoints = new Point[NUMBER_OF_LINES];

        for(int i=0; i<NUMBER_OF_LINES;i++){
            startPoints[i] = new Point(new Random().nextDouble()*100-50, new Random().nextDouble()*100-50);
            endPoints[i] = new Point(new Random().nextDouble()*100-50, new Random().nextDouble()*100-50);
            Line line = new Line(startPoints[i], endPoints[i]);
            lines.add(line);

            System.out.println(line.toString() + " length is " + line.getLength());
        }

        System.out.println("Total length is " + lines.sumLengths());
        System.out.println("Longest line with length " + lines.longestLine().getLength() + " is " + lines.longestLine().toString());




    }

}

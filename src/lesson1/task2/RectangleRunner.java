package lesson1.task2;

import java.util.Scanner;

/**
 *
 * @author Oleksii.Sergiienko
 */
public class RectangleRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangles rectangles = new Rectangles();

        Rectangle r = new Rectangle(2, 5);
        rectangles.add(r);
        System.out.println("Rectangle perimeter = " + r.getPerimeter());
        System.out.println("Rectangle area size = " + r.getArea());
        System.out.println("");

        r = new Rectangle(22, 12);
        rectangles.add(r);
        System.out.println("Rectangle perimeter = " + r.getPerimeter());
        System.out.println("Rectangle area size = " + r.getArea());
        System.out.println("");

        System.out.println("Total area is " + rectangles.getArea());

        try {
            new Rectangle(0, 0);
            new Rectangle(-1, 1);
            new Rectangle(1, -4.5);
            new Rectangle(-22.5, -4.5);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Enter is-not-double simbol for finish:");
        rectangles = new Rectangles();
        Scanner scanner = new Scanner(System.in);
        double x;
        double y;
        while (true) {
            System.out.print("x=");
            if (!scanner.hasNextDouble()) {
                break;
            }
            x = scanner.nextDouble();
            System.out.print("y=");
            if (!scanner.hasNextDouble()) {
                break;
            }
            y = scanner.nextDouble();

            rectangles.add(new Rectangle(x, y));

        }

        System.out.println("Total area is " + rectangles.getArea());
    }
}

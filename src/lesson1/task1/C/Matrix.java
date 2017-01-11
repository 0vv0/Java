package lesson1.task1.C;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 18.12.2016.
 */
class Matrix {
    final private int size;
    final private int[][] matrix;

    Matrix(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Incorrect dimension: " + n);
        }
        size = n;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -n + (int) (Math.random() * (2 * n + 1));
            }
        }
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < size; i++) {
            StringJoiner sj = new StringJoiner(", ", "", "\n");

            for (int j = 0; j < size; j++) {
                sj.add(String.format("%2d", matrix[i][j]));
            }
            s += sj;
        }
        return s;
    }

    void turnCounterClockWise(int angle) {
        switch (angle) {
            case 270:
                turn();
            case 180:
                turn();
            case 90:
                turn();
                break;
            default:
                throw new IllegalArgumentException("Incorrect angle (90, 180, 270 only): " + angle);
        }
    }

    private void turn() {
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][size - 1 - i];
                matrix[j][size - 1 - i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            Matrix matrix = new Matrix(scanner.nextInt());
            System.out.println(matrix);

            matrix.turnCounterClockWise(90);
            System.out.println("-90");
            System.out.println(matrix);

            matrix.turnCounterClockWise(90);
            System.out.println("-180");
            System.out.println(matrix);

            matrix.turnCounterClockWise(90);
            System.out.println("-270");
            System.out.println(matrix);

        }
    }


}

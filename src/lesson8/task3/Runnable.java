package lesson8.task3;

import java.util.Scanner;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class Runnable {
    public static void main(String[] args) {
        Train train = new BooleanTrain(10);

        System.out.println(train);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(train);

            if(scanner.next().equals("s")){break;}
        }
        System.out.println(train);
    }
}

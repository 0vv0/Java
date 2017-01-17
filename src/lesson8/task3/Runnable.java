package lesson8.task3;

import java.util.Scanner;

/**
 * Created by Oleksii.Sergiienko on 1/1/2017.
 */
public class Runnable {
    public static void main(String[] args) {
        Train train = new BooleanTrain(5);

//        System.out.println(train);
//        System.out.println(((BooleanTrain) train).getLength());

        System.out.println("l - move left\nr - move right\n+ - light on\n- - light off\n? - light is on?\ns - stop\nnumber - answer");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        while (scanner.hasNext()) {
            if(scanner.hasNextInt()){
                if(train.isLength(scanner.nextInt())) {
                    System.out.println("correct");
                    System.out.println(train);
                    break;
                } else {
                    System.out.println("incorrect");
                    continue;
                }
            } else {
                s = scanner.nextLine();
            }

            if(s.equals("s")){
                break;
            }else if (s.equals("l")) {
                train.moveLeft();
            } else if (s.equals("r")) {
                train.moveRight();
            } else if (s.equals("+")) {
                train.lightOn();
            } else if (s.equals("-")) {
                train.lightOff();
            } else if (s.equals("?")) {
                System.out.println(train.isLightOn());
            }
        }
    }
}

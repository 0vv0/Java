package lesson1.task1.B;

import java.util.Scanner;

/**
 * Created by Oleksii.Sergiienko on 18.12.2016.
 */
public class Month {
    private int month;

    Month(int n){
        month = n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("any letter for finish");
        while (true){
            System.out.print("Enter the number of Months (1-12):");
            if(scanner.hasNextInt()) {
                System.out.println(new Month(scanner.nextInt()).toString());
            } else {
                break;
            }
        }

    }

    private static boolean isMonth(int i){
        return (i > 0) && (i < 13);
    }

    public String toString(){
        switch (month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Not a Month";
        }
    }
}
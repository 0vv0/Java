package lesson1.task1.A;

import java.lang.*;
import java.util.Scanner;

/**
 * Created by Oleksii.Sergiienko on 18.12.2016.
 */
class PalindromeRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Palindromes palindromes = new Palindromes();

        System.out.println("Enter numbers (any letter for enough)");
        while (true){
            System.out.print(">>");
            if(scanner.hasNextInt()){
                palindromes.add(
                        new Number(scanner.nextInt())
                        ,2);
            }
            else {break;}
        }

        System.out.println(palindromes.toString());
    }

}

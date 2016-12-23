package lesson1.task1.A;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 18.12.2016.
 */
public class Palindromes {
    private ArrayList<Number> al = new ArrayList<>();
    void add(Number number, int capacity){
        if(number.isPalindrom()&&al.size()<capacity){al.add(number);}
    }

    public String toString(){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Number n:al) {
            sj.add(n.toString());
        }
        return sj.toString();
    }
}

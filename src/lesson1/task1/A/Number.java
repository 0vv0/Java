package lesson1.task1.A;

/**
 * Created by Oleksii.Sergiienko on 18.12.2016.
 */
class Number {
    private String theNumber;
    Number(int x){
        theNumber = String.valueOf(x);
    }

    boolean isPalindrom(){
        for (int i = 0; i<= theNumber.length()/2; i++){
            if(theNumber.charAt(i)!= theNumber.charAt(theNumber.length()-i-1)){return false;}
        }
        return true;
    }

    int getInt(){
        return Integer.parseInt(theNumber);
    }

    public String toString(){
        return theNumber;
    }
}

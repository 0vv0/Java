package lesson7.task2;

import lesson7.task1.Pair;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Runner {
    public static void main(String[] args) {
// Создать класс Range<T extends Number & Comparable<T>> (возможно, используя класс Pair<L, R>).
// Range применяется для хранения промежутка (например, Range<Integer>, Range<Long>).
// Необходимо осуществлять проверки на корректность диапазона (нижняя граница должна быть не больше, чем верхняя).
// Объекты класса Range должны быть неизменяемые (Immutable). Создать клиентский класс, демонстрирующий работу Range.

        System.out.println(new Range<>(5,10));
        System.out.println(new Range<>(-1.1,0.));
        System.out.println(new Range<>(Integer.MIN_VALUE,Integer.MAX_VALUE));
        try {
            System.out.println(new Range<>(5, 0));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }
}

class Range<T extends Number & Comparable<T>>{
    private final Pair<T, T> range;

    public Range(Pair<T, T> range) {
        this.range = range;
    }

    public Range(T left, T right) {
        if(left.compareTo(right)>0){throw new IllegalArgumentException("Left(" + left + ")>Right("+right+")");}
        range = new Pair<>(left,right);
    }

    @Override
    public String toString() {
        return range.toString();
    }

}



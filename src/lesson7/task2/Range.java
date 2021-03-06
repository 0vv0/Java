package lesson7.task2;

import lesson7.task1.Pair;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Range<T extends Number & Comparable<T>> {
    private final Pair<T, T> range;

    public Range(@NotNull Pair<@NotNull T, @NotNull T> range) {
        this(range.getLeft(), range.getRight());
    }

    public Range(@NotNull T left, @NotNull T right) {
        if (left.compareTo(right) > 0) {
            throw new IllegalArgumentException("Exception: Left(" + left + ")>Right(" + right + ")");
        }
        range = new Pair<>(left, right);
    }

    public static void main(String[] args) {
// Создать класс Range<T extends Number & Comparable<T>> (возможно, используя класс Pair<L, R>).
// Range применяется для хранения промежутка (например, Range<Integer>, Range<Long>).
// Необходимо осуществлять проверки на корректность диапазона (нижняя граница должна быть не больше, чем верхняя).
// Объекты класса Range должны быть неизменяемые (Immutable). Создать клиентский класс, демонстрирующий работу Range.

        System.out.println(new Range<>(5, 10));
        System.out.println(new Range<>(-1.1, 0.));
        System.out.println(new Range<>(Integer.MIN_VALUE, Integer.MAX_VALUE));
        try {
            System.out.println(new Range<>(127, -128));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(new Range<>(new Pair<>(1f, -1f)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public String toString() {
        return range.toString();
    }

}



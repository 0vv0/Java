package lesson7.task1;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Runner {
//    Создать класс Pair<L, R>, хранящий пару значений (L left, R right).
// Объекты класса Pair должны быть неизменяемые (Immutable).
// Создать клиентский класс, демонстрирующий работу Pair.

    public static void main(String[] args) {
        Pair<Integer, Integer> pairOfInts = new Pair<>(1, 12);
        Pair<Pair<String, Integer>, Pair<String, Integer>> parents = new Pair<>(
                new Pair<>("Mom", 59),
                new Pair<>("Dad", 60)
        );

        System.out.println(pairOfInts);
        System.out.println(pairOfInts.getLeft());
        System.out.println(pairOfInts.getRight());

        System.out.println(new Pair<String, Integer>("Hello", 12));
        System.out.printf(parents.toString());
    }
}

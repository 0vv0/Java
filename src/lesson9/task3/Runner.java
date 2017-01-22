package lesson9.task3;

import java.util.*;

/**
 * Created by default on 1/22/2017.
 */
public class Runner {
//    Numbers Counter. Сложность: *. Приоритет: **.
//    Задан List<Integer> list. Посчитать, сколько раз в списке попадается каждое число.
//            Подсказка: HashMap.

    private static List<Integer> list;

    public static void main(String[] args) {
        Map<Integer, Integer> counter = new HashMap<>();
        fill(100, 10);//100 elements from 0 to 10

        //count numbers
        for (int i : list) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        //list.forEach(x-> System.out.println(x));
        counter.entrySet()
                .forEach(x -> System.out.println("Number of " + x.getKey() + "==" + x.getValue()));

    }

    public static void fill(int count, int limit) {
        list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(limit) + 1000);
        }
    }
}

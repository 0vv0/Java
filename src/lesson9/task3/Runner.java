package lesson9.task3;

import java.util.*;

/**
 * Created by default on 1/22/2017.
 */
public class Runner {
//    Numbers Counter. Сложность: *. Приоритет: **.
//    Задан List<Integer> list. Посчитать, сколько раз в списке попадается каждое число.
//            Подсказка: HashMap.

    private List<Integer> list;
    private Map<Integer, Integer> counter = new HashMap<>();

    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.fill(1000, 11);//1000 elements from 0 to 10
        runner.count();

        runner.getCounter().entrySet()
                .forEach(x -> System.out.println("Number of " + x.getKey() + "==" + x.getValue()));

    }

    public void fill(int count, int limit) {
        list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(limit));
        }
    }

    public void count() {
        //count numbers
        for (int i : list) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
    }

    public Map<Integer, Integer> getCounter() {
        return counter;
    }
}

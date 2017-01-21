package lesson9.task2;

import lesson7.task4.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by default on 1/22/2017.
 */
public class Runner {
    //    Задан List<Person> persons. Создать структуру, позволяющую быстро выполнять запросы:
//            1. Найти всех людей подроствого возраста (от 12 до 17 лет).
//            2. Найти младшего человека, старше 18 лет.
//3. Найти старшего человека, младше 18 лет.
//    Продемонстрировать работу этих запросов и оценить сложность.
//            Подсказка: TreeMap.
    static List<Person> persons = new ArrayList<Person>() {
        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner("\n");
            this.forEach(x -> sj.add(x.toString()));
            return "-----------------\n" + sj.toString() + "\n******************\n";
        }
    };

    public static void main(String[] args) {
        fill();
        System.out.println("\n12-17:");
        persons.stream()
                .filter(x -> x.getAge() >= 12 && x.getAge() <= 17)
                .forEach(System.out::println);
        System.out.println("\n18+:");
        persons.stream()
                .filter(x -> x.getAge() > 18)
                .sorted((x, y) -> x.getAge() - y.getAge())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("\n-18:");
        persons.stream()
                .filter(x -> x.getAge() < 18)
                .sorted((x, y) -> y.getAge() - x.getAge())
                .limit(1)
                .forEach(System.out::println);


    }

    private static void fill() {
        persons.add(new Person("Oleksii", 36, Person.Sex.Male));
        persons.add(new Person("Olga", 17, Person.Sex.Female));
        persons.add(new Person("Irene", 17, Person.Sex.Female));
        persons.add(new Person("Inna", 16, Person.Sex.Female));
        persons.add(new Person("Ana", 17, Person.Sex.Female));
        persons.add(new Person("Anton", 22, Person.Sex.Male));
        persons.add(new Person("Andrew", 26, Person.Sex.Male));
        persons.add(new Person("Dennis", 13, Person.Sex.Male));
        persons.add(new Person("Peter", 17, Person.Sex.Male));
        persons.add(new Person("Peter", 15, Person.Sex.Male));
        persons.add(new Person("Peter", 17, Person.Sex.Male));
        persons.add(new Person("Igor", 17, Person.Sex.Male));
        persons.add(new Person("Alex", 17, Person.Sex.Male));
    }

}

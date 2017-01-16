package lesson9.task1;

import lesson7.task4.Person;

import java.util.*;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class Runner {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>() {
            @Override
            public String toString() {
                StringJoiner sj = new StringJoiner("\n");
                this.forEach(x -> sj.add(x.toString()));
                return "-----------------\n" + sj.toString() + "\n******************\n";
            }
        };
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

        System.out.println("Select all alphabetically");

        persons.stream()
                .sorted(((o1, o2) -> o1.getName().compareTo(o2.getName())))
                .map(x -> x.getName())
                .distinct()
                .forEach(x -> System.out.println(
                        persons.parallelStream()
                                .filter(y -> y.getName().equals(x)).findFirst().get()
                ));
    }
}
package lesson7.task4;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class Runner {
    //    Задан List<Person> persons.
// Из исходного списка выбрать всех людей подросткового возраста (age >= 12 && age <= 17);
// отсортировать по возрасту от старшего к младшему, в группах с одним возрастом - по имени в алфавитном порядке.
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>() {
            @Override
            public String toString() {
                StringJoiner sj = new StringJoiner("\n\t", "List of Persons:\n\t", "\nTotal: ");
                this.forEach(x -> sj.add(x.toString()));
                int i = this.size();
                return sj.toString() + i + (i < 2 ? " person" : " persons") + "\n\n";
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
        persons.add(new Person("Peter", 18, Person.Sex.Male));
        persons.add(new Person("Igor", 17, Person.Sex.Male));
        persons.add(new Person("Peter", 17, Person.Sex.Male));

        System.out.printf(persons.toString());


        System.out.printf("Sorted by age and name:\n");
        persons.stream().sorted(Person::compareTo).forEach(x -> System.out.printf("\t" + x.toString() + "\n"));
        System.out.printf("****************\n");

        LocalTime lt1 = LocalTime.now();
        System.out.printf("Select men from 12 to 17,\n sorted by age and name:\n");
        persons
                .stream()
                .sorted(Person::compareTo)
                .filter(x -> x.getSex() == Person.Sex.Male && x.getAge() >= 12 && x.getAge() <= 17)
                .forEach(x -> System.out.printf("\t" + x.toString() + "\n"));
        System.out.printf("****************\n");
        LocalTime lt2 = LocalTime.now();
        System.out.println("dt=" + (lt2.getNano() - lt1.getNano()) / 1000);

        lt1 = LocalTime.now();
        System.out.printf("Select men from 12 to 17,\n sorted by age and name:\n");
        persons
                .stream()
                .filter(x -> x.getSex() == Person.Sex.Male && x.getAge() >= 12 && x.getAge() <= 17)
                .sorted(Person::compareTo)
                .forEach(x -> System.out.printf("\t" + x.toString() + "\n"));
        System.out.printf("****************\n");
        lt2 = LocalTime.now();
        System.out.println("dt=" + (lt2.getNano() - lt1.getNano()) / 1000);

    }
}

package lesson2.task3;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class PuppyRunner {
    public static void main(String[] args) {
        Animal animal = new Puppy("Tim");
        System.out.println(animal.getNickname());
        animal.getSound();

        ((Puppy)animal).jump();
        ((Puppy)animal).run();
        ((Puppy)animal).bark();

        Dog rex = (Dog) animal;
        animal.setNickname("Rex");
        System.out.println(animal.getNickname());
        animal.getSound();

    }
}

package lesson2.task3;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Puppy extends Dog {
    Puppy() {
    }

    Puppy(String nickname) {
        super(nickname);
    }

    @Override
    void bark() {
        System.out.println("puppy wow-wow-wow");
    }

    @Override
    void jump() {
        System.out.println("puppy jumpy-jumpy");
    }

    @Override
    void run() {
        System.out.println("puppy shoor-shoor");
    }

    @Override
    void bite() {
        System.out.println("puppy rrrrrrr-argh");
    }
}

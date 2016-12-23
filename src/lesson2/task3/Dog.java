package lesson2.task3;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Dog extends Animal {
    Dog() {
    }

    Dog(String nickname) {
        super(nickname);
    }

    @Override
    void getSound() {
        bark();
    }

    void bark(int numberOfBarks){
        for (int i = 0; i<numberOfBarks;i++){
            bark();
        }
    }

    void bark(){
        System.out.println("dog Buf-buf");
    }

    void jump(){
        System.out.println("dog jump-jump");
    }

    void run(){
        System.out.println("dog jump-jump-jump-jump-jump");
    }

    void bite(){
        System.out.println("dog Rrr-wow- hampf");
    }
}

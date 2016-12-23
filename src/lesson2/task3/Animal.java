package lesson2.task3;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public abstract class Animal {
    private String nickname;

    Animal() {
        this.nickname = "unnamed";
    }

    Animal(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    abstract void getSound();
}

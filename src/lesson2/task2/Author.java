package lesson2.task2;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Author {
    private final String nick;
    private final String name;
    private final String surname;
    private final int yearOfBirth;

    Author(String nickname, String name, String surname, int yearOfBirth) {
        this.nick = nickname == null ? "" : nickname;
        this.name = name == null ? "" : name;
        this.surname = surname == null ? "" : surname;
        this.yearOfBirth = yearOfBirth > 1000 ? yearOfBirth : 0;
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + nick + ", " + yearOfBirth + ")";
    }

    public String getNick() {
        return nick;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}

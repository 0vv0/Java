package lesson2.task2;

/**
 * Created by Oleksii.Sergiienko on 19.12.2016.
 */
public class Author {
    private String nick = "";
    private String name = "";
    private String surname = "";
    private int yearOfBirth = 0;

    /**
     * @param nickname
     * @param name
     * @param surname
     * @param yearOfBirth
     */
    Author(String nickname, String name, String surname, int yearOfBirth) {
        this.nick = nickname;
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public String toString(){
        return name + " " + surname + "(" + nick + ", " + yearOfBirth + ")";
    }

    public void setNick(String nick) {
        this.nick = nick;
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

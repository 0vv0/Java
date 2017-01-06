package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class NamedPerson {
    private String name = null;
    private String surname = null;

    public NamedPerson(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName();
    }
}

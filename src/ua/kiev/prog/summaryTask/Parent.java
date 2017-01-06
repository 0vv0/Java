package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Parent implements IPerson {
    private String name;
    private String surname;

    public Parent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return getSurname() + " " + getName();
    }

}

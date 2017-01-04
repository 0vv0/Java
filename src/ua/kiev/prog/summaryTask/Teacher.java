package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Teacher implements IPerson, ITeach {
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public int mark(Task task, String answer) {
        return 0;
    }
}

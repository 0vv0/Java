package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface IPerson {
    String name = null;
    String surname = null;

    default String getName() {
        return name;
    }

    default String getSurname() {
        return surname;
    }

}

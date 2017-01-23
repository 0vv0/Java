package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Task;
import ua.kiev.prog.school.interfaces.Teacher;

import java.util.Random;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class RandomTeacher extends NamedPerson implements Teacher {

    public RandomTeacher(String name, String surname) {
        super(name, surname);
    }

    @Override
    public Mark mark(Task task) {

        switch (new Random().nextInt(12) + 1) {
            default:
                return Mark.F;
            case 3:
            case 4:
                return Mark.E;
            case 5:
            case 6:
                return Mark.D;
            case 7:
            case 8:
                return Mark.C;
            case 9:
            case 10:
                return Mark.B;
            case 11:
            case 12:
                return Mark.A;

        }
    }

    @Override
    public Task createTask(String taskText) {
        return new SimpleTask(taskText);
    }
}

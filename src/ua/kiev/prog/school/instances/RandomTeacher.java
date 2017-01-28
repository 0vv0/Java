package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Answer;
import ua.kiev.prog.school.interfaces.Task;
import ua.kiev.prog.school.interfaces.Teacher;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class RandomTeacher extends NamedPerson implements Teacher {

    public RandomTeacher(String name, String surname) {
        super(name, surname);
    }

    @Override
    public Mark mark(Answer answer) {

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
    public Map<Answer, Mark> mark(Set<Answer> answers) {
        Map<Answer, Mark> marks = new HashMap<>();
        for (Answer answer : answers) {
            marks.put(answer, mark(answer));
        }
        return marks;
    }

    @Override
    public Task createTask(String taskText) {
        return new SimpleTask(taskText);
    }
}

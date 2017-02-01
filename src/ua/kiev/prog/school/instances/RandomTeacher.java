package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
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
    public @NotNull Task.Mark mark(Task.@NotNull Question question, Task.@NotNull Answer answer) {
        if (answer.getAnswer().equals("") || answer.getAnswer().equals(Task.DEFAULT_ANSWER)) {
            return Task.Mark.UNMARKED;
        }
        switch (new Random().nextInt(12) + 1) {
            default:
                return Task.Mark.F;
            case 3:
            case 4:
                return Task.Mark.E;
            case 5:
            case 6:
                return Task.Mark.D;
            case 7:
            case 8:
                return Task.Mark.C;
            case 9:
            case 10:
                return Task.Mark.B;
            case 11:
            case 12:
                return Task.Mark.A;
        }
    }

    @Override
    public @NotNull Task mark(Task task) {
        return task.setMark(mark(task.getQuestion(), task.getAnswer()));
    }

    @Override
    public @NotNull Task.Question ask(@NotNull String question) {
        return new Task.Question() {
            @Override
            public String getQuestion() {
                return question + "?";
            }

            @Override
            public String toString() {
                return getQuestion();
            }
        };
    }

    @Override
    public @NotNull Task giveATask() {
        return giveATask(ask());
    }

    @Override
    public @NotNull Task giveATask(Task.Question question) {
        return new SimpleTask(question);
    }
}

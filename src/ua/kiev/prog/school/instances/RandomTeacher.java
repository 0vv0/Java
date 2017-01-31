package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Answer;
import ua.kiev.prog.school.interfaces.Question;
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
    public @NotNull Mark mark(@NotNull Question question, @NotNull Answer answer) {
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
    public @NotNull Question ask(@NotNull String question) {
        return new Question() {
            @Override
            public String getQuestion() {
                return question;
            }

            @Override
            public int compareTo(Question o) {
                return question.compareTo(o.getQuestion());
            }
        };
    }
}

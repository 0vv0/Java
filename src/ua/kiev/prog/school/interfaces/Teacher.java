package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Teacher {
    @NotNull Task.Mark mark(@NotNull Task.Question question, @NotNull Task.Answer answer);

    @NotNull Task mark(@NotNull Task task);

    @NotNull Task.Question ask(String question);

    @NotNull
    default Task.Question ask() {
        return new Task.Question() {
            @Override
            public String getQuestion() {
                return "Who is on duty today?";
            }
        };
    }

    @NotNull Task giveATask();

    @NotNull Task giveATask(Task.Question question);
}

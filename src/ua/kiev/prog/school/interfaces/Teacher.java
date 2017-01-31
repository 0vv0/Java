package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.Mark;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Teacher {
    @NotNull Mark mark(@NotNull Question question, @NotNull Answer answer);

    @NotNull Question ask(String question);

    @NotNull default Question ask(){
        return new Question() {
            @Override
            public String getQuestion() {
                return "Who is on duty today?";
            }

            @Override
            public int compareTo(Question o) {
                return getQuestion().compareTo(o.getQuestion());
            }
        };
    };
}

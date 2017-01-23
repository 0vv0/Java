package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.Mark;

/**
 * Created by admin on 1/23/2017.
 */
public interface Task {
    String getQuestion();

    Task setAnswer(@NotNull String answer);

    String getAnswer();

    Task setMark(@NotNull Mark mark);

    default Mark getMark() {
        return Mark.UNMARKED;
    }
}

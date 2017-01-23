package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;

/**
 * Created by admin on 1/23/2017.
 */
public interface Answer {

    Task getTask();

    Answer save(@NotNull String answer);

    default String getAnswer(){
        return toString();
    }
}

package ua.kiev.prog.school.interfaces;


import org.jetbrains.annotations.NotNull;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Pupil extends Person{
    Answer giveAnswer(@NotNull Question question);
}

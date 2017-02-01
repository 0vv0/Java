package ua.kiev.prog.school.interfaces;


import org.jetbrains.annotations.NotNull;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Pupil extends Person{
    Task.Answer giveAnswer(@NotNull Task.Question question);
}

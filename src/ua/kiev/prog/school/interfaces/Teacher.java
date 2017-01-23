package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.Mark;
import ua.kiev.prog.school.instances.Task;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Teacher {
    Mark mark(Task task);
    Task createTask(String taskText);
}

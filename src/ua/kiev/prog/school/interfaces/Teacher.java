package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.Mark;
import java.util.Map;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Teacher {
    Mark mark(Answer answer);
    Map<Answer, Mark> mark(Set<Answer> answers);
    Task createTask(String question);
}

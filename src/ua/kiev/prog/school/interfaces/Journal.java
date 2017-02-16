package ua.kiev.prog.school.interfaces;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by admin on 1/23/2017.
 */
public interface Journal extends Iterable<Pupil> {

    Map<Task.Question, Task.Mark> showMarks(Pupil pupil);

    Set<Pupil> toList();

    Teacher getMaster();

    Journal setMaster(Teacher teacher);

    Journal add(Pupil pupil);

    Journal add(Pupil pupil, Task task);

    Journal add(Pupil pupil, Set<Task> tasks);

    Journal add(Task task);

    Journal remove(Pupil pupil);

    Journal clearTasksFor(Pupil pupil);

    Journal filterByPupil(Predicate<Pupil> filter);

    Journal filterByTask(Predicate<Task> filter);

    boolean contains(Pupil pupil);
}

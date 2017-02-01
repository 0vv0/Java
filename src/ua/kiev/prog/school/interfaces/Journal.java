package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by admin on 1/23/2017.
 */
public interface Journal extends Iterable<Pupil> {

    Map<Task.Question, Task.Mark> showMarks(@NotNull Pupil pupil);

    Teacher getMaster();

    Journal setMaster(@NotNull Teacher teacher);

    Journal add(@NotNull Pupil pupil);

    Journal add(@NotNull Task.Question question);

    Journal add(@NotNull Set<Task.Question> question);

    Journal add(@NotNull Pupil pupil, @NotNull Task.Question question);

    Journal add(@NotNull Pupil pupil, @NotNull Task task);

    Journal add(@NotNull Pupil pupil, @NotNull Set<Task> task);

    Journal remove(@NotNull Pupil pupil);

    Journal clearTasksFor(@NotNull Pupil pupil);

    Journal filterByPupil(Predicate<Pupil> filter);

    Journal filterByTask(Predicate<Task> filter);

    boolean contains(@NotNull Pupil pupil);
}

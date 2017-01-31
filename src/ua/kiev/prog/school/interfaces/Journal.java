package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.Mark;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by admin on 1/23/2017.
 */
public interface Journal extends Iterable<Pupil> {
    Map<Question, Mark> showMarks(@NotNull Pupil pupil);

    Journal setMaster(@NotNull Teacher teacher);

    Teacher getMaster();

    Journal add(@NotNull Pupil pupil);

    Journal add(@NotNull Question question);

    Journal add(@NotNull Pupil pupil, @NotNull Question question);

    Journal add(@NotNull Pupil pupil, @NotNull Question question, @NotNull Mark mark);

    Journal add(@NotNull Pupil pupil, @NotNull MarkedTask markedTask);

    Journal add(@NotNull Pupil pupil, @NotNull Set<MarkedTask> markedTask);

    Journal remove(@NotNull Pupil pupil);

    Journal clearTasksFor(@NotNull Pupil pupil);

    Journal filterByPupil(Predicate<Pupil> filter);

    Journal filterByTask(Predicate<Question> filter);

    Journal filterByMark(Predicate<Mark> filter);

    boolean contains(@NotNull Pupil pupil);
}

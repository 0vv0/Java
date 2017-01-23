package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.Mark;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 1/23/2017.
 */
public interface Journal {
    Map<Task, Mark> showMarks(@NotNull Pupil pupil);

    Journal add(@NotNull Pupil pupil);

    Journal add(@NotNull Pupil pupil, @NotNull Task task);

    Journal add(@NotNull Pupil pupil, @NotNull List<Task> tasks);

    Journal remove(@NotNull Pupil pupil);

    Journal setMark(@NotNull Pupil pupil, @NotNull Map<Answer, Mark> marks);

    Journal setMark(@NotNull Pupil pupil, @NotNull Answer answer, @NotNull Mark mark);

    Journal clearTasksFor(@NotNull Pupil pupil);

    Teacher getMaster();

    Journal setMaster(@NotNull Teacher teacher);

}

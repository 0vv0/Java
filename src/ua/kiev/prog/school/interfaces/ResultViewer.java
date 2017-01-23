package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.ClassJournal;
import ua.kiev.prog.school.instances.SimpleTask;

/**
 * Created by admin on 1/23/2017.
 */
public interface ResultViewer {
    void viewResult(@NotNull Journal journal, @NotNull Pupil pupil);
    void viewResult(@NotNull Journal journal, @NotNull Pupil pupil, Task task);
}

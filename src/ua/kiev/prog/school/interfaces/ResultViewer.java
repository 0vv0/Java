package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.ClassJournal;
import ua.kiev.prog.school.instances.Task;

/**
 * Created by admin on 1/23/2017.
 */
public interface ResultViewer {
    void viewResult(ClassJournal journal, Pupil pupil);
    void viewResult(ClassJournal journal, Pupil pupil, Task task);
}

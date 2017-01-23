package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.TaskWithAnswer;

import java.util.List;

/**
 * Created by admin on 1/23/2017.
 */
public interface Parent {
    List<TaskWithAnswer> checkMarks(Pupil pupil);
}

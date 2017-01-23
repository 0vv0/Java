package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.MarkedAnswers;
import ua.kiev.prog.school.instances.Task;

import java.util.List;

/**
 * Created by admin on 1/23/2017.
 */
public interface Journal {
    MarkedAnswers showMarks(Pupil pupil);
}

package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.instances.Mark;

/**
 * Created by admin on 1/23/2017.
 */
public interface ResultViewer {

    default String viewResult(@NotNull Journal journal, @NotNull Pupil pupil) {
        return journal.showMarks(pupil).toString();
    }

    default String viewResult(@NotNull Journal journal, @NotNull Pupil pupil, Question question) {
        return journal.showMarks(pupil).getOrDefault(question, Mark.UNMARKED).toString();
    }
}

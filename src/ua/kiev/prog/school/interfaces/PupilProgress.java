package ua.kiev.prog.school.interfaces;

import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 2/16/2017.
 */
public interface PupilProgress extends Iterable<Task> {
    Pupil getPupil();

    PupilProgress setPupil(Pupil pupil);

    Set<Task> toList();

    PupilProgress put(Task task);

    PupilProgress delete(Task task);

    PupilProgress clear();

    boolean contains(Task task);
}

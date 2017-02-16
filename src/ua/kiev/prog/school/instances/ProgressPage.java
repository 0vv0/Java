package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.PupilProgress;
import ua.kiev.prog.school.interfaces.Task;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 2/16/2017.
 */
public class ProgressPage implements PupilProgress, Serializable {
    private static final long serialVersionUID = 1L;

    private Pupil pupil;
    private Set<Task> tasks = new HashSet<>();

    @Override
    public Pupil getPupil() {
        return pupil;
    }

    @Override
    public PupilProgress setPupil(Pupil pupil) {
        this.pupil = pupil;
        return this;
    }

    @Override
    public Set<Task> toList() {
        return new HashSet<>(tasks);
    }

    @Override
    public PupilProgress put(Task task) {
        tasks.add(task);
        return this;
    }

    @Override
    public PupilProgress delete(Task task) {
        tasks.remove(task);
        return this;
    }

    @Override
    public PupilProgress clear() {
        tasks = new HashSet<>();
        return this;
    }

    @Override
    public boolean contains(Task task) {
        return tasks.contains(task);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgressPage)) return false;

        ProgressPage pp = (ProgressPage) o;

        return getPupil() != null ? getPupil().equals(pp.getPupil()) : pp.getPupil() == null;
    }

    @Override
    public int hashCode() {
        return getPupil() != null ? getPupil().hashCode() : 0;
    }
}

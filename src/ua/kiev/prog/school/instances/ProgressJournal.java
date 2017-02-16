package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.*;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 2/16/2017.
 */
public class ProgressJournal implements Journal, Serializable {
    private static final long serialVersionUID = 1L;

    private Teacher master;
    private Set<PupilProgress> journal = new HashSet<>();

    public ProgressJournal(Teacher teacher) {
        this.master = teacher;
    }

    public ProgressJournal() {
    }

    @Override
    public Map<Task.Question, Task.Mark> showMarks(Pupil pupil) {
        Map<Task.Question, Task.Mark> marks = new HashMap<>();
        PupilProgress pupilProgress = journal.parallelStream()
                .filter(x -> x.getPupil().equals(pupil))
                .findAny().orElse(null);
        if (pupilProgress != null) {
            for (Task task : pupilProgress) {
                marks.put(task.getQuestion(), task.getMark());
            }
        }
        return marks;
    }

    @Override
    public Set<Pupil> toList() {
        return journal.parallelStream().map(x -> x.getPupil()).collect(Collectors.toSet());
    }

    @Override
    public Teacher getMaster() {
        return master;
    }

    @Override
    public Journal setMaster(Teacher teacher) {
        this.master = teacher;
        return this;
    }

    @Override
    public Journal add(Pupil pupil) {
        if (!contains(pupil)) {
            journal.add(new ProgressPage().setPupil(pupil));
        }
        return this;
    }

    @Override
    public Journal add(Pupil pupil, Task task) {
        add(pupil);
        journal.parallelStream()
                .filter(x -> x.getPupil().equals(pupil))
                .forEach(x -> x.put(task));
        return this;
    }

    @Override
    public Journal add(Pupil pupil, Set<Task> tasks) {
        for (Task task : tasks) {
            add(pupil, task);
        }
        return this;
    }

    @Override
    public Journal add(Task task) {
        journal.parallelStream()
                .forEach(x -> x.put(task));
        return this;
    }

    @Override
    public Journal remove(Pupil pupil) {
        for (PupilProgress pupilProgress : journal) {
            if (pupilProgress.getPupil().equals(pupil)) {
                journal.remove(pupilProgress);
                return this;
            }
        }
        return this;
    }

    @Override
    public Journal clearTasksFor(Pupil pupil) {
        journal.parallelStream()
                .filter(x -> x.getPupil().equals(pupil))
                .forEach(x -> x.clear());
        return this;
    }

    @Override
    public Journal filterByPupil(Predicate<Pupil> filter) {
        Journal j = new ProgressJournal(master);
        journal.parallelStream()
                .filter(x -> filter.test(x.getPupil()))
                .forEach(x -> j.add(x.getPupil(), x.toList()));
        return j;
    }

    @Override
    public Journal filterByTask(Predicate<Task> filter) {
        Journal j = new ProgressJournal(master);
        for (PupilProgress pupilProgress : journal) {
            pupilProgress.toList().parallelStream()
                    .filter(filter)
                    .forEach(x -> j.add(pupilProgress.getPupil(), x));
        }
        return j;
    }

    @Override
    public boolean contains(Pupil pupil) {
        for (PupilProgress pupilProgress : journal) {
            if (pupilProgress.getPupil().equals(pupil)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Pupil> iterator() {
        return new Iterator<Pupil>() {
            private Iterator<PupilProgress> progressIterator = journal.iterator();

            @Override
            public boolean hasNext() {
                return progressIterator.hasNext();
            }

            @Override
            public Pupil next() {
                return progressIterator.next().getPupil();
            }
        };
    }
}

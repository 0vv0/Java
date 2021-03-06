package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Journal;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.Task;
import ua.kiev.prog.school.interfaces.Teacher;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public final class ClassJournal implements Journal, Serializable {
    private static final long serialVersionUID = 1L;

    private Teacher master;
    private Map<Pupil, Set<Task>> journal = new HashMap<>();

    public ClassJournal(Teacher master) {
        this.master = master;
    }

    private boolean isAlreadyAsked(Pupil pupil, Task.Question question) {
        if (contains(pupil)) {
            for (Task mt : journal.get(pupil)) {
                if (mt.getQuestion().equals(question)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Pupil> iterator() {
        return new Iterator<Pupil>() {
            private Iterator<Pupil> iterator = journal.keySet().iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Pupil next() {
                return iterator.next();
            }

            @Override
            public void forEachRemaining(Consumer<? super Pupil> action) {
                iterator.forEachRemaining(action);
            }
        };
    }

    @Override
    public Map<Task.Question, Task.Mark> showMarks(Pupil pupil) {
        Map<Task.Question, Task.Mark> marks = new TreeMap<>();
        if (contains(pupil)) {
            journal.get(pupil).forEach(x -> marks.put(x.getQuestion(), x.getMark()));
        }
        return marks;
    }

    @Override
    public Set<Pupil> toList() {
        return journal.keySet();
    }

    @Override
    public Journal add(Pupil pupil) {
        journal.putIfAbsent(pupil, new TreeSet<>());
        return this;
    }


    @Override
    public Journal add(Pupil pupil, Task task) {
        if (!contains(pupil)) {
            add(pupil);
        }
        journal.get(pupil).add(task);
        return this;
    }

    @Override
    public Journal add(Pupil pupil, Set<Task> tasks) {
        if (!contains(pupil)) {
            add(pupil);
        }
        journal.get(pupil).addAll(tasks);
        return this;
    }

    @Override
    public Journal add(Task task) {
        journal.entrySet().forEach(x -> x.getValue().add(task));
        return this;
    }

    @Override
    public Journal filterByPupil(Predicate<Pupil> filter) {
        Journal j = new ClassJournal(master);
        journal.keySet().parallelStream().filter(filter).forEach(x -> j.add(x, journal.get(x)));
        return j;
    }

    @Override
    public Journal filterByTask(Predicate<Task> filter) {
        Journal j = new ClassJournal(master);
        for (Pupil pupil : journal.keySet()) {
            Set<Task> tasks = journal.get(pupil).stream()
                    .filter(filter)
                    .collect(Collectors.toSet());
            if (tasks.size() > 0) {
                j.add(pupil, tasks);
            }
        }

        return j;
    }

    @Override
    public boolean contains(Pupil pupil) {
        return journal.keySet().contains(pupil);
    }

    @Override
    public Journal remove(Pupil pupil) {
        journal.remove(pupil);
        return this;
    }

    @Override
    public Journal clearTasksFor(Pupil pupil) {
        journal.put(pupil, new TreeSet<>());
        return this;
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
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        journal
                .forEach(
                        (x, y) -> sj
                                .add(x.toString())
                                .add("\t" + y.toString()));
        return "Master " + master + ":\n" + sj;
    }
}

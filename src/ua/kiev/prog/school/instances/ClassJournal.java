package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class ClassJournal implements Journal {
    private Map<Pupil, Map<Answer, Mark>> journal = new HashMap<>();
    private Teacher master;

    public ClassJournal(@NotNull Teacher master) {
        this.master = master;
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
    public Map<Task, Mark> showMarks(@NotNull Pupil pupil) {
        Map<Task, Mark> marks = new HashMap<>();
        journal.getOrDefault(pupil, new HashMap<>()).forEach((x, y) -> marks.put(x.getTask(), y));
        return marks;
    }

    @Override
    public Journal add(@NotNull Pupil pupil) {
        journal.putIfAbsent(pupil, new HashMap<>());
        return this;
    }

    @Override
    public Journal set(Pupil pupil, Map<Answer, Mark> map) {
        journal.put(pupil, map);
        return this;
    }

    @Override
    public Journal filterByPupil(Predicate<Pupil> filter) {
        Journal j = new ClassJournal(master);
        journal.keySet().stream().filter(filter).forEach(x -> j.set(x, journal.get(x)));
        return j;
    }

    @Override
    public Journal filterByTask(Predicate<Task> filter) {
        Journal j = new ClassJournal(master);
        for (Pupil pupil : journal.keySet()) {
            Map<Answer, Mark> marks = journal.get(pupil);
            marks.keySet().stream()
                    .filter(x -> filter.test(x.getTask()))
                    .forEach(x -> j.setMark(pupil, x, marks.get(x)));
        }
        return j;
    }

    @Override
    public Journal filterByMark(Predicate<Mark> filter) {
        Journal j = new ClassJournal(master);
        for (Pupil pupil : journal.keySet()) {
            Map<Answer, Mark> marks = journal.get(pupil);
            marks.keySet().stream()
                    .filter(x -> filter.test(marks.get(x)))
                    .forEach(x -> j.setMark(pupil, x, marks.get(x)));
        }
        return j;
    }

    @Override
    public Map<Pupil, Map<Answer, Mark>> getJournal() {
        return new HashMap<>(journal);
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull Task task) {
        add(pupil);
        journal.get(pupil).putIfAbsent(new StableAnswer(task), Mark.UNMARKED);
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull List<Task> tasks) {
        add(pupil);
        for (Task task : tasks) {
            journal.get(pupil).putIfAbsent(new StableAnswer(task), Mark.UNMARKED);
        }
        return this;
    }

    @Override
    public Journal remove(@NotNull Pupil pupil) {
        journal.remove(pupil);
        return this;
    }

    @Override
    public Journal setMark(@NotNull Pupil pupil, @NotNull Map<Answer, Mark> marks) {
        marks.keySet().forEach(x -> setMark(pupil, x, marks.get(x)));
        return this;
    }

    @Override
    public Journal setMark(@NotNull Pupil pupil, @NotNull Answer answer, @NotNull Mark mark) {
        add(pupil);
        journal.get(pupil).put(answer, mark);
        return this;
    }

    @Override
    public Journal clearTasksFor(@NotNull Pupil pupil) {
        journal.put(pupil, new HashMap<>());
        return this;
    }

    @Override
    public Teacher getMaster() {
        return master;
    }

    @Override
    public Journal setMaster(@NotNull Teacher teacher) {
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
                                .add("\t" + y));
        return "Master " + master + ":\n" + sj;
    }
}

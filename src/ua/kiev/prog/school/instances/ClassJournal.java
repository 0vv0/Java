package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Journal;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.Task;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class ClassJournal implements Iterable<Pupil>, Journal {
    private Map<Pupil, List<Task>> journal = new HashMap<>();

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
        return null;
    }

    @Override
    public Journal add(@NotNull Pupil pupil) {
        journal.putIfAbsent(pupil, new ArrayList<>());
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull Task task) {
        add(pupil);
        journal.get(pupil).add(task);
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull List<Task> tasks) {
        add(pupil);
        journal.get(pupil).addAll(tasks);
        return this;
    }

    @Override
    public Journal remove(@NotNull Pupil pupil) {
        journal.remove(pupil);
        return this;
    }

    @Override
    public Journal setMark(@NotNull Pupil pupil, @NotNull Task task, @NotNull Mark mark) {
        add(pupil);
        journal.get(pupil).add(task.setMark(mark));
        return this;
    }

    @Override
    public Journal clearTasksFor(@NotNull Pupil pupil) {
        return this;
    }
}

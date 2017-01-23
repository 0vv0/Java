package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.*;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class ClassJournal implements Iterable<Pupil>, Journal {
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
        return null;
    }

    @Override
    public Journal add(@NotNull Pupil pupil) {
        journal.putIfAbsent(pupil, new HashMap<>());
        return this;
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
        marks.keySet().forEach(x->setMark(pupil, x, marks.get(x)));
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
                        (x,y)->sj
                                .add(x.toString())
                                .add("\t" + y));
        return "Master " + master + ":\n" + sj;
    }
}

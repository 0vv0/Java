package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public final class ClassJournal implements Journal {
    private Teacher master;
    private Map<Pupil, Set<MarkedTask>> journal = new HashMap<>();

    public ClassJournal(@NotNull Teacher master) {
        this.master = master;
    }

    private boolean isAlreadyAsked(@NotNull Pupil pupil, @NotNull Question question) {
        if (contains(pupil)) {
            for (MarkedTask mt : journal.get(pupil)) {
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
    public Map<Question, Mark> showMarks(@NotNull Pupil pupil) {
        Map<Question, Mark> marks = new TreeMap<>();
        if (contains(pupil)) {
            journal.get(pupil).forEach(x -> marks.put(x.getQuestion(), x.getMark()));
        }
        return marks;
    }

    @Override
    public Journal add(@NotNull Pupil pupil) {
        journal.putIfAbsent(pupil, new TreeSet<>());
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull Question question) {
        if (contains(pupil)) {
            for (MarkedTask mt : journal.get(pupil)) {
                if (mt.getQuestion().equals(question)) {
                    return this;
                }
            }
        } else {
            add(pupil);
        }
        journal.get(pupil).add(new SimpleMarkedTask(question));
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull Question question, @NotNull Mark mark) {
        add(pupil);
        MarkedTask mt = journal.get(pupil).stream()
                .filter(x->x.getQuestion().equals(question))
                .findFirst()
                .orElse(new SimpleMarkedTask(question).setMark(mark));
        add(pupil,mt);
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull MarkedTask markedTask) {
        if(!contains(pupil)){add(pupil);}
        journal.get(pupil).add(markedTask);
        return this;
    }

    @Override
    public Journal add(@NotNull Pupil pupil, @NotNull Set<MarkedTask> markedTasks) {
        if(!contains(pupil)){add(pupil);}
        journal.get(pupil).addAll(markedTasks);
        return this;
    }

    @Override
    public Journal add(@NotNull Question question) {
        journal.keySet().forEach(x -> add(x, question));
        return this;
    }

    @Override
    public Journal filterByPupil(Predicate<Pupil> filter) {
        Journal j = new ClassJournal(master);
        journal.keySet().parallelStream().filter(filter).forEach(x -> j.add(x, journal.get(x)));
        return j;
    }

    @Override
    public Journal filterByTask(Predicate<Question> filter) {
        Journal j = new ClassJournal(master);
        for (Pupil pupil : journal.keySet()) {
            j.add(pupil, journal.get(pupil).stream()
                    .filter(x -> filter.test(x.getQuestion()))
                    .collect(Collectors.toSet()));
        }
        return j;
    }

    @Override
    public Journal filterByMark(Predicate<Mark> filter) {
        Journal j = new ClassJournal(master);
        for (Pupil pupil : journal.keySet()) {
            j.add(pupil, journal.get(pupil).stream()
                    .filter(x -> filter.test(x.getMark()))
                    .collect(Collectors.toSet()));
        }
        return j;
    }

    @Override
    public boolean contains(@NotNull Pupil pupil) {
        return journal.keySet().contains(pupil);
    }

    @Override
    public Journal remove(@NotNull Pupil pupil) {
        journal.remove(pupil);
        return this;
    }

    @Override
    public Journal clearTasksFor(@NotNull Pupil pupil) {
        journal.put(pupil, new TreeSet<>());
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
                                .add("\t" + y.toString()));
        return "Master " + master + ":\n" + sj;
    }
}

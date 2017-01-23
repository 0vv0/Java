package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Journal;
import ua.kiev.prog.school.interfaces.Pupil;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class ClassJournal implements Iterable<Pupil>, Journal {
    private Map<Pupil, MarkedAnswers> journal = new HashMap<>();

    ClassJournal add(Pupil pupil, MarkedAnswers answers){
        journal.put(pupil, answers);
        return this;
    }

    ClassJournal add(Pupil pupil, Task task, Mark mark){
        MarkedAnswers markedAnswers = journal.getOrDefault(pupil, new MarkedAnswers());
        markedAnswers.writeMark(task, mark);
        journal.put(pupil, markedAnswers);
        return this;
    }

    public ClassJournal remove(Pupil pupil){
        journal.remove(pupil);
        return this;
    }

    public MarkedAnswers answersFor(Pupil pupil){
        return journal.get(pupil);
    }

    public Set<Pupil> getAll(){
        return new HashSet<>(journal.keySet());
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
    public MarkedAnswers showMarks(Pupil pupil) {
        return null;
    }
}

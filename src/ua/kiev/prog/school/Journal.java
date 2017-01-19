package ua.kiev.prog.school;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class Journal implements Iterable<Pupil>{
    private Map<Pupil, Answers> journal = new HashMap<>();
    Journal add(Pupil pupil, Answers answers){
        journal.put(pupil, answers);
        return this;
    }

    public Journal remove(Pupil pupil){
        journal.remove(pupil);
        return this;
    }

    public Answers answersFor(Pupil pupil){
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
}

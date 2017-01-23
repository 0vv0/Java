package ua.kiev.prog.school.instances;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class Journal implements Iterable<StablePupil>{
    private Map<StablePupil, Answers> journal = new HashMap<>();
    Journal add(StablePupil stablePupil, Answers answers){
        journal.put(stablePupil, answers);
        return this;
    }

    public Journal remove(StablePupil stablePupil){
        journal.remove(stablePupil);
        return this;
    }

    public Answers answersFor(StablePupil stablePupil){
        return journal.get(stablePupil);
    }

    public Set<StablePupil> getAll(){
        return new HashSet<>(journal.keySet());
    }

    @Override
    public Iterator<StablePupil> iterator() {
        return new Iterator<StablePupil>() {
            private Iterator<StablePupil> iterator = journal.keySet().iterator();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public StablePupil next() {
                return iterator.next();
            }

            @Override
            public void forEachRemaining(Consumer<? super StablePupil> action) {
                iterator.forEachRemaining(action);
            }
        };
    }
}

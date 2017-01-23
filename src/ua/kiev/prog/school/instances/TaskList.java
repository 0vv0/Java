package ua.kiev.prog.school.instances;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public class TaskList implements Iterable<Task>, Serializable {
    private List<Task> tasks = new ArrayList<>();

    public TaskList add(Task... task) {
        for (Task t : task) {
            if (t != null) {
                tasks.add(t);
            }
        }
        return this;
    }

    public TaskList remove(Task task) {
        tasks.remove(task);
        return this;
    }

    List<Task> getAll() {
        return new ArrayList<>(tasks);
    }

    List<Task> get(Predicate<? super Task> predicate) {
        return new ArrayList<>(tasks.stream().filter(predicate).collect(Collectors.toList()));
    }
    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner("\n", "List of Tasks:\n", "\n***************");
        tasks.forEach(x -> sj.add(x.toString()));
        return sj.toString();
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private Iterator<Task> iter = tasks.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Task next() {
                return iter.next();
            }
        };
    }
}

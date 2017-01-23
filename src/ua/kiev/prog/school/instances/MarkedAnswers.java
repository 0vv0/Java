package ua.kiev.prog.school.instances;

import java.util.HashMap;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class MarkedAnswers implements Iterable<Task> {
    private HashMap<Task, Mark> marks = new HashMap<>();

    public MarkedAnswers writeMark(Task task, Mark mark){
        marks.put(task, mark);
        return this;
    }

    public Mark showMark(Task task){
        return marks.getOrDefault(task, Mark.UNMARKED);
    }

    @Override
    public  String toString(){
        StringJoiner sj = new StringJoiner("\n", "Marks:\n", "\n***************");
        marks.entrySet().forEach(x->sj.add(x.getKey().getTask()+ " mark is: " +x.getValue()));
        return sj.toString();
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            private Iterator<Task> iter = marks.keySet().iterator();
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

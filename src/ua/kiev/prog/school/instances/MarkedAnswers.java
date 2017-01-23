package ua.kiev.prog.school.instances;

import java.util.HashMap;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class MarkedAnswers implements Iterable<TaskWithAnswer> {
    private HashMap<TaskWithAnswer, Mark> marks = new HashMap<>();

    public MarkedAnswers(){}

    public MarkedAnswers setMark(TaskWithAnswer taskWithAnswer, Mark mark){
        marks.put(taskWithAnswer, mark);
        return this;
    }

    @Override
    public  String toString(){
        StringJoiner sj = new StringJoiner("\n", "Marks:\n", "\n***************");
        marks.entrySet().forEach(x->sj.add(x.getKey().getTask()+ " mark is: " +x.getValue()));
        return sj.toString();
    }

    @Override
    public Iterator<TaskWithAnswer> iterator() {
        return new Iterator<TaskWithAnswer>() {
            private Iterator<TaskWithAnswer> iter = marks.keySet().iterator();
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public TaskWithAnswer next() {
                return iter.next();
            }
        };
    }
}

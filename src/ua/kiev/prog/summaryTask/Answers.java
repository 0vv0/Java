package ua.kiev.prog.summaryTask;

import java.util.*;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public class Answers implements Iterable<TaskWithAnswer>{
    private Pupil pupil;
    private List<TaskWithAnswer> answers = new ArrayList<>();

    public Answers(Pupil pupil) {
        this.pupil = pupil;
    }

    public Answers addAnswer(Task task, String answer) {
        answers.add(new TaskWithAnswer(task).setAnswer(answer));
        return this;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n", "List of Answers of " + pupil.toString() + ":\n", "\n***************");
        answers.stream()
                .filter(Objects::nonNull)
                .forEach(x -> sj.add(x.getTask() + " answer is: " + x.getAnswer()));
        return sj.toString();
    }

    @Override
    public Iterator<TaskWithAnswer> iterator() {
        return new Iterator<TaskWithAnswer>() {
            private Iterator<TaskWithAnswer> iter = answers.iterator();
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

package ua.kiev.prog.summaryTask;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public class Answers {
    private HashMap<Task, IAnswer> tasks;

    public Answers addAnswer(Task task, IAnswer answer){
        tasks.put(task, answer);
        return this;
    }

    public String getAnswers(){
        StringJoiner sj = new StringJoiner("\n","List of Answers:\n", "***************");
        tasks.entrySet().stream()
                .filter(x->x.getValue()!=null)
                .forEach(x->{sj.add(x.getKey().getName() + " answer is: " + x.getValue());});
        return sj.toString();
    }

}

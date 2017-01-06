package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class TaskWithAnswer {
    private Task task;
    private String answer;

    public TaskWithAnswer(Task task) {
        this.task = task;
    }

    TaskWithAnswer setAnswer(String answer){
        this.answer = answer;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public String getAnswer() {
        return answer;
    }
}

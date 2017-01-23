package ua.kiev.prog.school.instances;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class TaskWithAnswer {
    private Task task;
    private String answer;

    public TaskWithAnswer(Task task) {
        this.task = task;
    }

    public TaskWithAnswer setAnswer(String answer){
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

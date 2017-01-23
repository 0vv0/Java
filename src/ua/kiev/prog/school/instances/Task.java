package ua.kiev.prog.school.instances;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Task {
    private final String text;
    private String answer;

    public Task(String text) {
        this.text = text;
    }

    public String getTask() {
        return text;
    }

    public Task setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return text + "\nAnswer:\n" + answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return text != null ? text.equals(task.text) : task.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}

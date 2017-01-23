package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Answer;
import ua.kiev.prog.school.interfaces.Task;

/**
 * Created by admin on 1/23/2017.
 */
public class StableAnswer implements Answer {
    private final Task task;
    private String answer = "___";

    public StableAnswer(Task task) {
        this.task = task;
    }

    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public Answer save(@NotNull String answer) {
        this.answer = answer;
        return this;
    }

    @Override
    public String toString() {
        return task + ": " + answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StableAnswer)) return false;

        StableAnswer that = (StableAnswer) o;

        return getTask().equals(that.getTask());
    }

    @Override
    public int hashCode() {
        return getTask().hashCode();
    }
}

package ua.kiev.prog.school.instances;


import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Task;

/**
 * Created by Oleksii.Sergiienko on 1/23/2017.
 */
public class SimpleTask implements Task {
    private static final long serialVersionUID = 1L;

    private final Question question;
    private Answer answer = DEFAULT_ANSWER;
    private Mark mark = Mark.UNMARKED;

    public SimpleTask(@NotNull Question question) {
        assert question != null;
        this.question = question;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public Task setAnswer(@NotNull Answer answer) {
        this.answer = answer;
        return this;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public Task setMark(@NotNull Mark mark) {
        this.mark = mark;
        return this;
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task that = (Task) o;

        return getQuestion() != null ? getQuestion().equals(that.getQuestion()) : that.getQuestion() == null;
    }

    @Override
    public int hashCode() {
        return getQuestion().hashCode();
    }

    @Override
    public String toString() {
        return getQuestion() + "(" + getMark() + ", " + getAnswer() + ")";
    }
}

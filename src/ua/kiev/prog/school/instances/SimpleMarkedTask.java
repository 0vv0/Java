package ua.kiev.prog.school.instances;


import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Answer;
import ua.kiev.prog.school.interfaces.Question;
import ua.kiev.prog.school.interfaces.MarkedTask;

/**
 * Created by Oleksii.Sergiienko on 1/23/2017.
 */
public class SimpleMarkedTask implements MarkedTask {
    private final Question question;
    private Answer answer;
    private Mark mark;

    public SimpleMarkedTask(@NotNull Question question) {
        this.question = question;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public MarkedTask setAnswer(@NotNull Answer answer) {
        this.answer = answer;
        return this;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public MarkedTask setMark(@NotNull Mark mark) {
        this.mark = mark;
        return this;
    }

    @Override
    public Mark getMark() {
        return mark;
    }
}

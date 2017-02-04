package ua.kiev.prog.school.instances;


import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Task;

import java.io.*;

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

    @Override
    public void write() throws IOException {
        write(new File(getSaveFileName()));
    }

    @Override
    public void write(File file) throws IOException {
        new BufferedWriter(new FileWriter(
                new File(file.getName() + ".q"))).write(question.getQuestion());
        new BufferedWriter(new FileWriter(
                new File(file.getName() + ".a"))).write(answer.getAnswer());
        new BufferedWriter(new FileWriter(file)).write(mark.name());
    }

    @Override
    public Task read(File file) throws IOException {
        String markString = new BufferedReader(new FileReader(new File(getSaveFileName()))).readLine();
        String question = new BufferedReader(new FileReader(new File(file.getName() + ".q")))
                .readLine();
        String answer = new BufferedReader(new FileReader(new File(file.getName() + ".a")))
                .readLine();

        return new SimpleTask(new Question() {
            @Override
            public String getQuestion() {
                return question;
            }
        }).setAnswer(new Answer() {
            @Override
            public String getAnswer() {
                return answer;
            }
        }).setMark(Mark.valueOf(markString));
    }
}

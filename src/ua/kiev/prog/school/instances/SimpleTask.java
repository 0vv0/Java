package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Task;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class SimpleTask implements Task {
    private final String text;
    private String answer = "";

    public SimpleTask(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Question missed");
        }
        this.text = text;
    }

    @Override
    public String getQuestion() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public Task setAnswer(@NotNull String answer) {
        this.answer = answer;
        return this;
    }

    @Override
    public String toString() {
        return text + "\nAnswer:\n" + answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleTask)) return false;

        SimpleTask that = (SimpleTask) o;

        return text.equals(that.text)
                && (
                getAnswer() != null
                        ? getAnswer().equals(that.getAnswer())
                        : that.getAnswer() == null
        );
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + (getAnswer() != null ? getAnswer().hashCode() : 0);
        return result;
    }

}

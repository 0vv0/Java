package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Task;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class SimpleTask implements Task {
    private final String text;

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


    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleTask)) return false;

        SimpleTask that = (SimpleTask) o;

        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}

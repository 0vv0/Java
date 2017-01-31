package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Question;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class SimpleQuestion implements Question {
    private final String text;

    public SimpleQuestion(String text) {
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
        if (!(o instanceof SimpleQuestion)) return false;

        SimpleQuestion that = (SimpleQuestion) o;

        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public int compareTo(Question o) {
        return this.text.compareTo(o.getQuestion());
    }
}

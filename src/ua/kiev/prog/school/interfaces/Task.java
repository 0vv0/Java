package ua.kiev.prog.school.interfaces;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by admin on 1/31/2017.
 */
public interface Task extends Comparable<Task>, Serializable, Writeable, Readable<Task> {
    Answer DEFAULT_ANSWER = new Answer() {
        @Override
        public String getAnswer() {
            return "__";
        }

        @Override
        public String toString() {
            return getAnswer();
        }
    };
    Mark DEFAULT_MARK = Mark.UNMARKED;

    Question getQuestion();

    default Answer getAnswer() {
        return DEFAULT_ANSWER;
    }

    Task setAnswer(Answer answer);

    default Mark getMark() {
        return DEFAULT_MARK;
    }

    Task setMark(Mark mark);

    @Override
    default int compareTo(@NotNull Task o) {
        return getQuestion().compareTo(o.getQuestion());
    }

    enum Mark {
        A, B, C, D, E, F, UNMARKED
    }

    interface Question extends Comparable<Question> {
        String getQuestion();

        @Override
        default int compareTo(@NotNull Question o) {
            return getQuestion().compareTo(o.getQuestion());
        }
    }

    interface Answer {
        String getAnswer();
    }
}

package ua.kiev.prog.school.interfaces;

/**
 * Created by admin on 1/31/2017.
 */
public interface Task extends Comparable<Task> {
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

    Mark getMark();

    Task setMark(Mark mark);

    @Override
    default int compareTo(Task o) {
        return getQuestion().compareTo(o.getQuestion());
    }

    enum Mark {
        A, B, C, D, E, F, UNMARKED
    }

    interface Question extends Comparable<Question> {
        String getQuestion();

        @Override
        default int compareTo(Question o) {
            return getQuestion().compareTo(o.getQuestion());
        }
    }

    interface Answer {
        String getAnswer();
    }
}

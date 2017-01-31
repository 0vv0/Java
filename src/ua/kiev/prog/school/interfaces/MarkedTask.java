package ua.kiev.prog.school.interfaces;

import ua.kiev.prog.school.instances.Mark;

/**
 * Created by admin on 1/31/2017.
 */
public interface MarkedTask {
    Question getQuestion();
    MarkedTask setAnswer(Answer answer);
    Answer getAnswer();
    MarkedTask setMark(Mark mark);
    Mark getMark();
}

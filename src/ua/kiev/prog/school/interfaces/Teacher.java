package ua.kiev.prog.school.interfaces;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public interface Teacher {
    Task.Mark mark(Task.Question question, Task.Answer answer);

    Task mark(Task task);

    Task.Question ask(String question);


    default Task.Question ask() {
        return new Task.Question() {
            @Override
            public String getQuestion() {
                return "Who is on duty today?";
            }

            @Override
            public String toString() {
                return getQuestion();
            }
        };
    }

    Task giveATask();

    Task giveATask(Task.Question question);
}

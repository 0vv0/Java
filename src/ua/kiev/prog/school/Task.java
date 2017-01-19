package ua.kiev.prog.school;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Task{
    private final String text;

    public Task(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return text != null ? text.equals(task.toString()) : task.toString() == null;
    }

    @Override
    public int hashCode() {
        return text != null ? toString().hashCode() : 0;
    }
}

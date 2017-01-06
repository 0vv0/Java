package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Task {
    private static int counter = 0;
    private final int id = counter++;
    private final String text;

    public Task(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString(){
        return "#" +id + ": " + text;
    }
}

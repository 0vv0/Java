package ua.kiev.prog.summaryTask;

import java.util.HashMap;

/**
 * Created by Oleksii.Sergiienko on 1/4/2017.
 */
public class Tasks {
    private HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();
    public Tasks add(Task... task) {
        for (Task t : task) {
            if (t != null) {
                tasks.put(t.getId(), t);
            }
        }
        return this;
    }

    public Tasks remove(Task task) {
        tasks.remove(task.getId());
        return this;
    }

    public Tasks remove(String taskName) {
        for (Task t:tasks.values()) {
            if(t.getName().equals(taskName)){tasks.remove(t.getId());}
            //break;
        }
        return this;
    }


}

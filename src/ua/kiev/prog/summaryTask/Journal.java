package ua.kiev.prog.summaryTask;

import java.util.HashMap;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class Journal {
    private HashMap<Pupil, Answers> journal = new HashMap<>();
    Journal add(Pupil pupil, Answers answers){
        journal.put(pupil, answers);
        return this;
    }

    Journal remove(Pupil pupil){
        journal.remove(pupil);
        return this;
    }

    @Override
    public  String toString(){
        //TODO
        return "";
    }

}

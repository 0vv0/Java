package ua.kiev.prog.summaryTask;

import java.util.Random;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Teacher implements IPerson, ITeach {
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public Mark mark(TaskWithAnswer task) {
        switch (new Random().nextInt(12)+1){
            default:
                return Mark.F;
            case 3:case 4:
                return Mark.E;
            case 5:case 6:
                return Mark.D;
            case 7:case 8:
                return Mark.C;
            case 9:case 10:
                return Mark.B;
            case 11:case 12:
                return Mark.A;

        }
    }


    @Override
    public String toString(){
        return getSurname() + " " + getName();
    }
}

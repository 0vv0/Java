package ua.kiev.prog.school;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Pupil extends NamedPerson implements Answerer {
    private NamedPerson mother;
    private NamedPerson father;

    public Pupil(String name, String surname, NamedPerson mother, NamedPerson father) {
        super(name, surname);
        this.mother = mother;
        this.father = father;
    }

    public NamedPerson getMother() {
        return mother;
    }

    public NamedPerson getFather() {
        return father;
    }

    @Override
    public String getAnswer(Task task) {
        return "This is my answer for : " + task;
    }

}

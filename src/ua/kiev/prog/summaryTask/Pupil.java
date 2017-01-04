package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Pupil implements IPerson, IStudy{
    private String name;
    private String surname;
    private IPerson mother;
    private IPerson father;

    public Pupil(String name, String surname, IPerson mother, IPerson father) {
        this.name = name;
        this.surname = surname;
        this.mother = mother;
        this.father = father;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public IPerson getMother() {
        return mother;
    }

    public IPerson getFather() {
        return father;
    }

    @Override
    public String answer(Task task) {
        return "He is my answer!!!!";
    }
}

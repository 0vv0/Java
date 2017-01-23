package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Pupil;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class StablePupil extends NamedPerson implements Pupil {
    private NamedPerson mother;
    private NamedPerson father;

    public StablePupil(String name, String surname, NamedPerson mother, NamedPerson father) {
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

    public static class Builder{
        private String name;
        private String surname;
        private NamedPerson mom;
        private NamedPerson dad;

        public Builder() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setMom(NamedPerson mom) {
            this.mom = mom;
        }

        public void setDad(NamedPerson dad) {
            this.dad = dad;
        }

        public StablePupil build(){
            return new StablePupil(name, surname, mom, dad);
        }
    }

}

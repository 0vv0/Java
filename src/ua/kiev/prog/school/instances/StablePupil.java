package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.Task;

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
    public Task giveAnswer(@NotNull Task task) {
        return new SimpleTask(task.getQuestion()).setAnswer("I know this simpleTask. Just a minute....");
    }

    public static class Builder{
        private String name;
        private String surname;
        private NamedPerson mom;
        private NamedPerson dad;

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

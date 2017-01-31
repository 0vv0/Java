package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Answer;
import ua.kiev.prog.school.interfaces.Person;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.Question;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class StablePupil extends NamedPerson implements Pupil {
    private Person mother;
    private Person father;

    public StablePupil(String name, String surname, Person mother, Person father) {
        super(name, surname);
        this.mother = mother;
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public Answer giveAnswer(@NotNull Question question) {
        return new Answer() {
            @Override
            public String getAnswer() {
                return "My stable answer - I KNOW ALL!!!";
            }
        };
    }

    public static class Builder {
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

        public StablePupil build() {
            return new StablePupil(name, surname, mom, dad);
        }
    }

}

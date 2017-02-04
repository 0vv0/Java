package ua.kiev.prog.school.instances;

import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Person;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.Task;

import java.io.*;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public final class StablePupil extends NamedPerson implements Pupil {
    private static final long serialVersionUID = 1L;

    private Person mother;
    private Person father;

    public StablePupil(String name, String surname, Person mother, Person father) {
        super(name, surname);
        assert mother != null;
        assert father != null;
        this.mother = mother;
        this.father = father;
    }

    @Override
    public Person read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] fileNames = br.readLine().split(";");
        assert fileNames.length == 3;
        //read pupil data
        String dataFromFile = new BufferedReader(new FileReader(new File(fileNames[0]))).readLine();
        String[] arr = dataFromFile.split(";");
        Person person = new NamedPerson(arr[0], arr[1]);
        //read mom data
        dataFromFile = new BufferedReader(new FileReader(new File(fileNames[1]))).readLine();
        arr = dataFromFile.split(";");
        Person mom = new Parent(arr[0], arr[1], arr[2]);
        //read dad data
        dataFromFile = new BufferedReader(new FileReader(new File(fileNames[2]))).readLine();
        arr = dataFromFile.split(";");
        Person dad = new Parent(arr[0], arr[1], arr[2]);

        return new StablePupil(person.getName(), person.getSurname(), mom, dad);
    }

    @Override
    public void write() throws IOException {
        write(new File(getSaveFileName()));
    }

    @Override
    public void write(File file) throws IOException {
        String name = file.getName();
        super.write(new File(name + ".sp"));
        mother.write(new File(name + ".mom"));
        father.write(new File(name + ".dad"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(name + ".sp" + ";" + name + ".mom" + ";" + name + ".dad");
        bw.close();
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public Task.Answer giveAnswer(@NotNull Task.Question question) {
        return new Task.Answer() {
            @Override
            public String getAnswer() {
                return "My stable answer - I KNOW ALL!!!";
            }

            @Override
            public String toString() {
                return getAnswer();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StablePupil)) return false;
        if (!super.equals(o)) return false;

        StablePupil that = (StablePupil) o;

        return getMother().equals(that.getMother()) && getFather().equals(that.getFather());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getMother().hashCode();
        result = 31 * result + getFather().hashCode();
        return result;
    }

    public static class Builder {
        private String name;
        private String surname;
        private NamedPerson mom;
        private NamedPerson dad;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setMom(NamedPerson mom) {
            this.mom = mom;
            return this;
        }

        public Builder setDad(NamedPerson dad) {
            this.dad = dad;
            return this;
        }

        public StablePupil build() {
            return new StablePupil(name, surname, mom, dad);
        }
    }
}

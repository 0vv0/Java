package ua.kiev.prog.school.instances;

import ua.kiev.prog.school.interfaces.Person;

import java.io.*;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class NamedPerson implements Person {
    private static final long serialVersionUID = 1L;

    private String name = "";
    private String surname = "";

    public NamedPerson(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Use Empty string, Null-s not allowed");
        }
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
    public String toString() {
        return getSurname() + " " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedPerson)) return false;

        NamedPerson that = (NamedPerson) o;

        return getName().equals(that.getName()) && getSurname().equals(that.getSurname());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        return result;
    }

    @Override
    public Person read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String buffer = br.readLine();
        br.close();
        String[] arr = buffer.split(";");
        if (arr.length < 2) {
            throw new IOException("Incorrect file format");
        }
        return new NamedPerson(arr[0], arr[1]);
    }

    @Override
    public void write() throws IOException {
        write(new File(getSaveFileName()));
    }

    @Override
    public void write(File file) throws IOException {
        String buffer = name + ";" + surname;
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(buffer);
        bw.newLine();
    }
}

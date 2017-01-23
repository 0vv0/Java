package ua.kiev.prog.school.instances;

/**
 * Created by Oleksii.Sergiienko on 1/6/2017.
 */
public class NamedPerson {
    private String name;
    private String surname;

    public NamedPerson(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

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

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(that.getSurname()) : that.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        return result;
    }
}

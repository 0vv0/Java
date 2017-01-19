package ua.kiev.prog.school;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Parent extends NamedPerson {
    private String address;

    public Parent(String name, String surname, String address) {
        super(name, surname);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

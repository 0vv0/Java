package ua.kiev.prog.school.instances;


/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Burger extends NamedPerson {
    private String address;

    public Burger(String name, String surname, String address) {
        super(name, surname);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

package ua.kiev.prog.school.instances;


import ua.kiev.prog.school.interfaces.ResultViewer;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Parent extends NamedPerson implements ResultViewer{
    private String address;

    public Parent(String name, String surname, String address) {
        super(name, surname);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
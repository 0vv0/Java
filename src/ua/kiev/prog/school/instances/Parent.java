package ua.kiev.prog.school.instances;


import org.jetbrains.annotations.NotNull;
import ua.kiev.prog.school.interfaces.Journal;
import ua.kiev.prog.school.interfaces.Pupil;
import ua.kiev.prog.school.interfaces.ResultViewer;
import ua.kiev.prog.school.interfaces.Task;

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

    @Override
    public void viewResult(@NotNull Journal journal, @NotNull Pupil pupil) {
        System.out.println(journal.showMarks(pupil));
    }

    @Override
    public void viewResult(@NotNull Journal journal, @NotNull Pupil pupil, Task task) {
        System.out.println(journal.showMarks(pupil));
    }
}

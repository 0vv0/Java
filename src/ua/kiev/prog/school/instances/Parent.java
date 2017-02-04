package ua.kiev.prog.school.instances;


import ua.kiev.prog.school.interfaces.Person;
import ua.kiev.prog.school.interfaces.ResultViewer;

import java.io.*;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public final class Parent extends NamedPerson implements ResultViewer {
    private static final long serialVersionUID = 1L;

    private String address;

    public Parent(String name, String surname, String address) {
        super(name, surname);
        this.address = address == null ? "" : address;
    }

    @Override
    public Person read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String buffer = br.readLine();
        br.close();
        String[] arr = buffer.split(";");
        if (arr.length != 3) {
            throw new IOException("File format is incorrect");
        }
        return new Parent(arr[0], arr[1], arr[2]);
    }

    @Override
    public void write() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(getSaveFileName())));
        String buffer = getName() + ";" + getSurname() + ";" + getAddress();
        bw.write(buffer);
        bw.newLine();
        bw.close();
    }

    @Override
    public void write(File file) throws IOException {
        super.write(file);
    }

    public String getAddress() {
        return address;
    }

}

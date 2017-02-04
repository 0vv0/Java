package ua.kiev.prog.school.instances;


import ua.kiev.prog.school.interfaces.ResultViewer;

import java.io.*;
import java.util.StringJoiner;

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
    public Parent read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String buffer = br.readLine();
        br.close();
        String[] arr = buffer.split(";");
        if (arr.length < 3) {
            throw new IOException("File format is incorrect");
        }
        StringJoiner sj = new StringJoiner("");
        for (int i = 2; i < arr.length; i++) {
            sj.add(arr[i]);
        }
        return new Parent(arr[0], arr[1], sj.toString());
    }

    @Override
    public void write(File file) throws IOException {
        super.write(file);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.append(";" + address);
        bw.close();
    }

    public String getAddress() {
        return address;
    }

}

package ua.kiev.prog.school.interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksii.Sergiienko on 2/4/2017.
 */
public interface Writeable {
    String DEFAULT_DIRECTORY = "files/";
    default void write() throws IOException {
        write(new File(getSaveFileName()));
    }

    void write(File file) throws IOException;

    default String getSaveFileName() {
        return getDirectory() + hashCode() + "." + getClass().getSimpleName();
    }

    default String getDirectory() {
        return DEFAULT_DIRECTORY;
    }
}

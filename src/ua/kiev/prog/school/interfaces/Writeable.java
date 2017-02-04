package ua.kiev.prog.school.interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksii.Sergiienko on 2/4/2017.
 */
public interface Writeable {
    default void write() throws IOException {
        write(new File(getSaveFileName()));
    }

    void write(File file) throws IOException;

    default String getSaveFileName() {
        return hashCode() + "." + getClass().getSimpleName();
    }
}

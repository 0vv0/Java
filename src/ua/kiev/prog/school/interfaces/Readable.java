package ua.kiev.prog.school.interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oleksii.Sergiienko on 2/4/2017.
 */
public interface Readable<T> {
    T read(File file) throws IOException;
}

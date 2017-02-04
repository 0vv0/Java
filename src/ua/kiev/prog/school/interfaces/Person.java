package ua.kiev.prog.school.interfaces;

import java.io.Serializable;

/**
 * Created by admin on 1/23/2017.
 */
public interface Person extends Serializable, Writeable, Readable<Person> {
    String getName();
    String getSurname();
}

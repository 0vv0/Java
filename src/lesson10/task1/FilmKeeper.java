package lesson10.task1;

import lesson6.task1.Film;
import lesson6.task1.Films;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by default on 1/28/2017.
 */
public class FilmKeeper extends Films implements IOFilms {
    @Override
    public void writeTo(File file) throws IOException {
        StringWriter sw = new StringWriter();
        for (Film film : this.getAll()) {

        }
        sw.close();
    }

    @Override
    public IOFilms readFrom(File file) throws IOException {
        return null;
    }
}

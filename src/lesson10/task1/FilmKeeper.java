package lesson10.task1;

import lesson6.task1.Film;
import lesson6.task1.Films;
import lesson6.task1.Genre;

import java.io.*;

/**
 * Created by default on 1/28/2017.
 */
public class FilmKeeper extends Films implements IOFilms, Serializable {
    public static IOFilms readFrom(File file) throws IOException, ClassNotFoundException {
        FilmKeeper fk = new FilmKeeper();
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = fr.readLine()) != null) {
                String[] arr = s.split(";");
                if (arr.length < 3) {
                    throw new RuntimeException("IncorrectFileFormat in line:\n" + s);
                }
                Film film = new Film(arr[0], Integer.parseInt(arr[2]), Genre.valueOf(arr[1]));
                for (int i = 3; i < arr.length; i++) {
                    film.addActor(arr[i]);
                }
                fk.add(film);
            }
        }
        return fk;
    }

    public static FilmKeeper deSerializeFrom(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            return (FilmKeeper) ois.readObject();
        }
    }

    @Override
    public void writeTo(File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Film film : this.getAll()) {
                bw.write(film.getName() + ";" + film.getGenre() + ";" + film.getYear());
                for (String s : film.getListOfActors()) {
                    bw.write(";" + s);
                }
                bw.newLine();
                bw.flush();
            }
        }
    }

    public void serializeTo(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(this);
            oos.flush();
        }
    }
}

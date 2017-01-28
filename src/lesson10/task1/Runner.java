package lesson10.task1;

import lesson6.task1.Film;
import lesson6.task1.Genre;

import java.io.*;

/**
 * Created by default on 1/28/2017.
 */
public class Runner {
    public static void main(String[] args) {
//        Создать классы:
//        1. Film: название, год выпуска, список имен актеров, список жанров.
//        2. IOFilms: List<Film> films (возможно, extends Films). Позволяет выполнять запросы:
//        a) Запись фильмов в текстовый файл.
//                b) Чтение фильмов из текстового файла.
//                c) Запись фильмов в бинарный файл (сериализация).
//                d) Чтение фильмов из бинарного файла (десериализация).

        IOFilms filmList = new FilmKeeper();

        Film zve5 = new Film("Star Wars. Episode 5", 1990, Genre.Fantastic);
        Film zve6 = new Film("Star Wars. Episode 6", 1992, Genre.Fantastic);
        Film zve3 = new Film("Star Wars. Episode 3", 1994, Genre.Fantastic);
        Film zve1 = new Film("Star Wars. Episode 1", 1999, Genre.Fantastic);

        Film scaryMovie = new Film("Scary movie", 1980, Genre.Horror);

        ((FilmKeeper) filmList).add(zve1).add(zve3).add(zve5).add(zve6).add(scaryMovie);
        System.out.println(filmList);

        {
            String filmListFileName = "c:\\git\\" + String.valueOf(filmList.hashCode()) + ".fs";
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(filmListFileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(filmList);
                oos.flush();
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }

            IOFilms films = null;

            try {
                FileInputStream fis = new FileInputStream(filmListFileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                films = (FilmKeeper) ois.readObject();
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            if (films != null) {
                System.out.println(">" + films + "<");
            } else {
                System.out.println("Can't read");
            }
        }
    }
}

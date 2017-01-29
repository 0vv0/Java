package lesson10.task1;

import lesson6.task1.Film;
import lesson6.task1.Genre;

import java.io.File;
import java.io.IOException;

/**
 * Created by default on 1/28/2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Создать классы:
//        1. Film: название, год выпуска, список имен актеров, список жанров.
//        2. IOFilms: List<Film> films (возможно, extends Films). Позволяет выполнять запросы:
//        a) Запись фильмов в текстовый файл.
//                b) Чтение фильмов из текстового файла.
//                c) Запись фильмов в бинарный файл (сериализация).
//                d) Чтение фильмов из бинарного файла (десериализация).

        IOFilms filmList = new FilmKeeper();

        Film zve5 = new Film("Star Wars. Episode 5", 1990, Genre.Fantastic);
        zve5.addActor("Lyuk SkyWalker");
        Film zve6 = new Film("Star Wars. Episode 6", 1992, Genre.Fantastic);
        Film zve3 = new Film("Star Wars. Episode 3", 1994, Genre.Fantastic);
        Film zve1 = new Film("Star Wars. Episode 1", 1999, Genre.Fantastic);

        Film scaryMovie = new Film("Scary movie", 1980, Genre.Horror);

        ((FilmKeeper) filmList).add(zve1).add(zve3).add(zve5).add(zve6).add(scaryMovie);
        System.out.println(filmList);

        {
            String filmListFileName = "src\\lesson10\\task1\\films\\" + String.valueOf(filmList.hashCode()) + ".sff";
            ((FilmKeeper) filmList).serializeTo(new File(filmListFileName));
            IOFilms films = FilmKeeper.deSerializeFrom(new File(filmListFileName));
            System.out.println("DeSerialized list:\n" + films + "<\n");
        }

        {
            String filmListFileName = "src\\lesson10\\task1\\films\\" + String.valueOf(filmList.hashCode()) + ".cvs";
            filmList.writeTo(new File(filmListFileName));
            IOFilms films = FilmKeeper.readFrom(new File(filmListFileName));
            System.out.println("Read from cvs list:\n" + films + "<\n");
            ((FilmKeeper) films).getAll().forEach(System.out::println);
        }
    }
}

package lesson10.task1;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by default on 1/28/2017.
 */
public interface IOFilms extends Serializable {
//    Создать классы:
//            1. Film: название, год выпуска, список имен актеров, список жанров.
//2. IOFilms: List<Film> films (возможно, extends Films). Позволяет выполнять запросы:
//    a) Запись фильмов в текстовый файл.
//            b) Чтение фильмов из текстового файла.
//            c) Запись фильмов в бинарный файл (сериализация).
//    d) Чтение фильмов из бинарного файла (десериализация).

    void writeTo(File file) throws IOException;

    IOFilms readFrom(File file) throws IOException;
}

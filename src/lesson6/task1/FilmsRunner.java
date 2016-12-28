package lesson6.task1;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class FilmsRunner {
    //            1. Film: название, год выпуска, список имен актеров, список жанров.
//2. Films: ArrayList<Film> films. Позволяет выполнить поиск:
//    a) список фильмов с заданными жанрами (например, HORROR и THRILLER).
//    b) список фильмов, выпущенных в заданные года (например, в диапазоне 1990-2000 rr.)
//    c) список фильмов, в которых снимаются заданные актеры.
//            3. Клиентский класс FilmsRunner, демонстрирующий работу предыдущих классов.
    public static void main(String[] args) {
        Films filmList = new Films();

        Film zve5 = new Film("Star Wars. Episode 5", 1990, IGenred.Genre.Fantastic);
        Film zve6 = new Film("Star Wars. Episode 6", 1992, IGenred.Genre.Fantastic);
        Film zve3 = new Film("Star Wars. Episode 3", 1994, IGenred.Genre.Fantastic);
        Film zve1 = new Film("Star Wars. Episode 1", 1999, IGenred.Genre.Fantastic);

        Film scaryMovie = new Film("Scary movie", 1980, IGenred.Genre.Horror);

        filmList.add(zve1).add(zve3).add(zve5).add(zve6).add(scaryMovie);

        System.out.println(filmList);
        filmList.getByGenre(IGenred.Genre.Fantastic).forEach(x-> System.out.println(x));
    }

}

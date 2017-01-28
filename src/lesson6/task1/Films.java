package lesson6.task1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Films implements Serializable {
    private final List<Film> films = new ArrayList<>();

    public Films() {
    }

    public Films(Film... films) {
        for (Film film : films) {
            if (film != null) {
                this.films.add(film);
            }
        }
    }

    public Films(List<Film> films) {
        for (Film film : films) {
            if (film != null) {
                this.films.add(film);
            }
        }
    }

    public Films add(Film film) {
        if (film != null) {
            this.films.add(film);
        }
        return this;
    }

    public Films remove(Film film) {
        for (Film film1 : films) {
            if (film.getName().equals(film1.getName())
                    && film.getYear() == film1.getYear()
                    ) {
                films.remove(film1);
                break;
            }
        }
        return this;
    }

    public Films getByGenre(Genre genre) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.getGenre() == genre)
                .forEach(list::add);
        return new Films(list);
    }

    public Films getByYears(int from, int to) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.getYear() >= from && x.getYear() <= to)
                .forEach(list::add);
        return new Films(list);
    }

    public Films getByActor(String actorName) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.isPlayActor(actorName))
                .forEach(list::add);
        return new Films(list);
    }

    public Films getByActors(String... actorsNames) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.isPlayActors(actorsNames))
                .forEach(list::add);
        return new Films(list);
    }

    public List<Film> getAll() {
        return new ArrayList<>(films);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        films
                .forEach(x -> sb.append(x.getName()).append(" (").append(x.getYear()).append(")\n"));
        return sb.toString();
    }
}

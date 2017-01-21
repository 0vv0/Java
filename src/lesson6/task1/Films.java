package lesson6.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
class Films {
    private final List<Film> films = new ArrayList<>();

    Films(){
    }

    Films(Film... films) {
        for (Film film : films) {
            if (film != null) {
                this.films.add(film);
            }
        }
    }

    Films(List<Film> films) {
        for (Film film : films) {
            if (film != null) {
                this.films.add(film);
            }
        }
    }

    Films add(Film film) {
        if (film != null) {
            this.films.add(film);
        }
        return this;
    }

    Films remove(Film film) {
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

    Films getByGenre(Genre genre) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.getGenre() == genre)
                .forEach(list::add);
        return new Films(list);
    }

    Films getByYears(int from, int to) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.getYear() >= from && x.getYear() <= to)
                .forEach(list::add);
        return new Films(list);
    }

    Films getByActor(String actorName) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.isPlayActor(actorName))
                .forEach(list::add);
        return new Films(list);
    }

    Films getByActors(String... actorsNames) {
        List<Film> list = new ArrayList<>();
        films
                .stream()
                .filter(x -> x.isPlayActors(actorsNames))
                .forEach(list::add);
        return new Films(list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        films
                .forEach(x -> sb.append(x.getName()).append(" (").append(x.getYear()).append(")\n"));
        return sb.toString();
    }
}

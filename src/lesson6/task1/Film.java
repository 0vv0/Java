package lesson6.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public class Film {
//            1. Film: название, год выпуска, список имен актеров, список жанров.

    private final String theName;
    private final int theYear;
    private List<String> actors = new ArrayList<>();
    private final Genre theGenre;

    public Film(String name, int year, Genre genre) {
        isCorrect(name, year);
        this.theName = name;
        this.theYear = year;
        this.theGenre = genre;
    }

    public Film(String name, int year) {
        this(name, year, Genre.UnKnown);
    }

    public Film(String name) {
        this(name, 0, Genre.UnKnown);
    }


    public Genre getGenre() {
        return theGenre;
    }

    String getName() {
        return theName;
    }

    int getYear() {
        return theYear;
    }

    Film addActor(String name) {
        if (name != null && name.length() > 0) {
            actors.add(name);
        }
        return this;
    }

    Film removeActor(String name) {
        for (String actor : actors) {
            if (actor.equals(name)) {
                actors.remove(actor);
                break;
            }
        }
        return this;
    }

    boolean isPlayActor(String actorName) {
        return actors
                .stream()
                .filter(x -> x.equals(actorName))
                .count() > 0;
    }

    boolean isPlayActors(String... actorsNames) {
        for (String name : actorsNames) {
            if(actors
                    .stream()
                    .filter(x -> x.equals(name))
                    .count() == 0){return false;}
        }
        return true;
    }

    List<String> getListOfActors() {
        return new ArrayList<>(actors);
    }

    private boolean isCorrect(String name, int year) {
        if (name == null) {
            throw new IllegalArgumentException("Name couldn't be null");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name couldn't be empty");
        }
        if (year < 1900 && year != 0) {
            throw new IllegalArgumentException("Film too old. Not acceptable");
        }
        if (year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Film from Future. Not acceptable");
        }

        return true;
    }

    @Override
    public String toString() {
        return theName + " (" + theYear + ", " + theGenre + ")";
    }
}

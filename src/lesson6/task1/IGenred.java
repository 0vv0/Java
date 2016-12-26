package lesson6.task1;

/**
 * Created by Oleksii.Sergiienko on 12/26/2016.
 */
public interface IGenred {
    enum Genre{
        UnKnown, Comedy, Fight, Tragedy, Fantastic, FairyTale, Horros, THRILLER
    }

    Genre getGenre();
}

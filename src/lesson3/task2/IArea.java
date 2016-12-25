package lesson3.task2;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public interface IArea {
    enum Type{
        Ocean, Island, Continent
    }

    String getName();

    Type getType();
}

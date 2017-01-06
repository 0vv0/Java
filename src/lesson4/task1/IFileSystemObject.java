package lesson4.task1;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public interface IFileSystemObject extends ISizable{
    String getName();

    default boolean isNotGoodForName(String name) {
        return name == null || name.length() < 1;
    }

}

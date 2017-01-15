package lesson4.task1;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
interface IFileSystemObject extends ISizable, Comparable<IFileSystemObject> {
    String getName();

    default boolean contains(IFileSystemObject fso) {
        return false;
    }

    default boolean isNotGoodForName(String name) {
        return name == null || name.length() < 1;
    }

    default String toString(int tabulator) {
        return toString();
    }

}

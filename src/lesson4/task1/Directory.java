package lesson4.task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public final class Directory implements IFileSystemObject, IReturnStringSize, Comparable<IFileSystemObject> {
    private static int counter = 0;
    private final String name;
    private final Set<IFileSystemObject> content = new HashSet<>();

    public Directory(String name) {
        assert name != null && name.length() > 0;
        if (isNotGoodForName(name)) {
            throw new IllegalArgumentException("Bad directory name");
        }
        this.name = name;
        counter++;
    }

    public Directory() {
        this.name = "dir" + counter++;
    }

    public Directory(IFileSystemObject... fileSystemObjects) {
        this();
        add(fileSystemObjects);
    }

    public Directory add(IFileSystemObject fileSystemObject) {
        if (fileSystemObject != null
                && fileSystemObject != this
                && content.stream().noneMatch(x -> x.getName().equals(fileSystemObject.getName()))) {
            content.add(fileSystemObject);
        }
        return this;
    }

    public Directory add(IFileSystemObject... fileSystemObjects) {
        Arrays.stream(fileSystemObjects)
                .filter(Objects::nonNull)
                .forEach(this::add);
        return this;
    }

    @Override
    public int getSize() {
        return content.stream().mapToInt(ISizable::getSize).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(IFileSystemObject o) {
        return name.compareTo(o.getName());
    }
}

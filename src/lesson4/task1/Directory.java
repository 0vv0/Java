package lesson4.task1;

import java.util.*;

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
        if (fileSystemObject != null) {
            if (contains(fileSystemObject)) {
                throw new IllegalArgumentException("Already have this FSO");
            }
            if (fileSystemObject.contains(this)) {
                throw new IllegalArgumentException("Can't add parent into child");
            }
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
    public boolean contains(IFileSystemObject fso) {
        if (fso == null) {
            return false;
        }
        if (this == fso || this.compareTo(fso) == 0) {
            return true;
        }
        for (IFileSystemObject ifo : content) {
            if (ifo.getName().equals(fso.getName()) || ifo.contains(fso)) {
                return true;
            }
        }
        return false;
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
        if (o == null) {
            return Integer.MAX_VALUE;
        }
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        //if(content.size()==0){return name;}
        return toString(0);
    }

    public String toString(final int countOfTabs) {
        if (countOfTabs < 0) {
            return toString();
        }
        StringJoiner sj = new StringJoiner("", "\n", "");
        StringJoiner sjTab = new StringJoiner("");
        for (int i = countOfTabs; i > 0; i--) {
            sjTab.add("|\t");
        }
        content.stream()
                .sorted((x, y) -> {
                    if (!x.contains(x) && y.contains(y)) {
                        return 1;
                    }
                    return x.compareTo(y);
                })
                .forEach(x -> sj.add(sjTab + "|---" + x.toString(countOfTabs + 1) + "\n"));

        return name + sj.toString().replaceAll("\n\n", "\n") + (countOfTabs == 0 ? "***********" : "");
    }
}

package lesson4.task1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Directory implements IFileSystemObject, IReturnStringSize {
    private static int counter = 0;
    private String name;
    private final Set<IFileSystemObject> content = new HashSet<>();

    public Directory(String name) {
        if (isNotGoodForName(name)) {
            throw new IllegalArgumentException("Bad directory name");
        }
        this.name = name;
    }

    public Directory(){
        this.name = "dir" + counter++;
    }

    public Directory(IFileSystemObject... fileSystemObject){
        this();
        for (IFileSystemObject iFS:fileSystemObject) {
            add(iFS);
        }
    }

    Directory add(IFileSystemObject fileSystemObject) {
        if (fileSystemObject == null) {
            throw new IllegalArgumentException("Cann't add null element");
        }
        if (fileSystemObject == this) {
            throw new IllegalArgumentException("Cyclic dependency: cann't add myself into myself. ");
        }
        for (IFileSystemObject iFS : content) {
            if (iFS.getName().equals(fileSystemObject.getName())) {
                return this;
            }
        }
        content.add(fileSystemObject);

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

}

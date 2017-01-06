package lesson4.task1;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class File implements IFileSystemObject, IReturnStringSize {
    private final String name;
    private int size;

    public File(String name, int size) {
        if (isNotGoodForName(name)) {
            throw new IllegalArgumentException("Bad file name");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Size<0 not supported");
        }
        this.name = name;
        this.size = size;
    }

    public File(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }


    @Override
    public int getSize() {
        return size;
    }
}

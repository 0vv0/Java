package lesson4.task1;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
interface IReturnStringSize {
    default String getStringSize(int sizeInBytes){
        assert sizeInBytes>=0;
        String s = sizeInBytes < 1024
                ? sizeInBytes + " "
                : sizeInBytes < 1024 * 1024
                ? sizeInBytes / 1024 + " K"
                : sizeInBytes / 1024 / 1024 + " M";
        return s + "b";
    }
}

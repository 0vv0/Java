package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
interface IHardware {
    String getName();

    default IHardware shutdown() {
        System.out.println(getName() + ": stopped");
        return this;
    }

    default IHardware start() {
        System.out.println(getName() + ": started");
        return this;
    }
}

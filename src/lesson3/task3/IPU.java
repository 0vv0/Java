package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public interface IPU extends IHardware {
    enum Type {
        CPU, GPU
    }

    Type getType();

    @Override
    default IHardware start() {
        System.out.println(this.getType() + " " + getName() + ": started");
        return this;
    }

    @Override
    default IHardware shutdown() {
        System.out.println(this.getType() + " " + getName() + ": stopped");
        return this;
    }
}

package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
interface IMemory extends IHardware {
    int getSize();

    default IMemory checkForViruses() {
        System.out.println(getName() + ": Virus free. Congratulations!!!");
        return this;
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

    enum Type {
        RAM, HDD, FDD
    }
}

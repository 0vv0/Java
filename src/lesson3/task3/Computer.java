package lesson3.task3;

import org.jetbrains.annotations.Contract;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Computer implements IHardware, Iterable<IHardware> {
    private final Set<IHardware> list = new HashSet<>();
    private final String theName;

    @Contract("null -> fail")
    Computer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is missed");
        }
        this.theName = name;
    }

    Computer() {
        this("Noname");
    }

    Computer add(IHardware hardware) {
        if (hardware != null && hardware != this) {
            list.add(hardware);
        }

        return this;
    }


    @Override
    public IHardware start() {
        for (IHardware iH : getOfTypeIPU(IPU.Type.CPU)) {
            iH.start();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.RAM)) {
            iH.start();
        }
        for (IHardware iH : getOfTypeIPU(IPU.Type.GPU)) {
            iH.start();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.HDD)) {
            iH.start();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.FDD)) {
            iH.start();
        }
        return this;
    }

    @Override
    public IHardware shutdown() {
        for (IHardware iH : getOfTypeIPU(IPU.Type.CPU)) {
            iH.shutdown();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.RAM)) {
            iH.shutdown();
        }
        for (IHardware iH : getOfTypeIPU(IPU.Type.GPU)) {
            iH.shutdown();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.HDD)) {
            iH.shutdown();
        }
        for (IHardware iH : getOfTypeIMemory(IMemory.Type.FDD)) {
            iH.shutdown();
        }
        return this;
    }

    @Override
    public String getName() {
        return theName;
    }

    private Set<IHardware> getOfTypeIPU(IPU.Type type) {
        Set<IHardware> iH = new HashSet<>();

        list
                .stream()
                .filter(x -> x instanceof ProcessorUnit)
                .filter(x -> ((ProcessorUnit) x).getType() == type)
                .forEach(iH::add);

        return iH;
    }

    private Set<IHardware> getOfTypeIMemory(IMemory.Type type) {
        Set<IHardware> iH = new HashSet<>();

        list
                .stream()
                .filter(x -> x instanceof Memory)
                .filter(x -> ((Memory) x).getType() == type)
                .forEach(iH::add);
        return iH;
    }

    void getSize() {

        list
                .stream()
                .filter(x -> x instanceof Memory)
                .forEach(x -> System.out.println(((Memory) x).getType() + ": " + x.getName() + " has size: " + ((Memory) x).getSize()));

    }

    @Override
    public Iterator<IHardware> iterator() {
        return new Iterator<IHardware>() {
            private Iterator<IHardware> iter = list.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public IHardware next() {
                return iter.next();
            }
        };
    }
}

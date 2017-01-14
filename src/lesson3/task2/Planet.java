package lesson3.task2;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Planet {
    private final String name;
    private final Set<IArea> list = new HashSet<IArea>();

    Planet(String planetName) throws IllegalArgumentException {
        if (planetName == null || planetName.length() == 0) {
            throw new IllegalArgumentException("Planet name is null");
        }
        this.name = planetName;
    }

    Planet() {
        this.name = "Earth";
    }

    Planet add(IArea area) {
        if (area == null) {
            return this;
        }
        for (IArea iA : list) {
            if (iA.equals(area)) {
                return this;
            }
        }
        list.add(area);
        return this;
    }

    Planet add(IArea... areas) {
        if (areas == null) {
            return this;
        }
        for (IArea iA : areas) {
            if (iA != null) {
                add(iA);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (IArea iA : list) {
            sj.add(iA.getName() + " - " + iA.getType());
        }

        return "Planet The " + name + " contains:\n" + sj;
    }

    long getOceansCount() {
        return countAllByType(IArea.Type.Ocean);
    }

    long getContinentsCount() {
        return countAllByType(IArea.Type.Continent);
    }

    long getIslandsCount() {
        return countAllByType(IArea.Type.Island);
    }

    long countAllByType(IArea.Type type) {
        return list
                .stream()
                .filter(x -> x.getType() == type)
                .count();
    }
}

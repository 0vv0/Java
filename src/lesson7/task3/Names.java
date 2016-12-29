package lesson7.task3;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class Names {
    private final List<String> names = new ArrayList<>();

    public Names() {
    }

    public Names(String... names) {
        for (String name : names) {
            if (name != null) {
                this.add(name);
            }
        }
    }

    public Names(List<String> names) {
        for (String name : names) {
            if (name != null) {
                this.add(name);
            }
        }
    }

    private static int sortAZ(String s1, String s2) {
        return s1.compareTo(s2);
    }

    private static int sortZA(String s1, String s2) {
        return sortAZ(s2, s1);
    }

    private static int sort1ToLongest(String s1, String s2) {
        return s1.length() > s2.length()
                ? 1
                : s1.length() == s2.length()
                ? 0 : -1;
    }

    private static int sortLongestTo1(String s1, String s2) {
        return sort1ToLongest(s2, s1);
    }

    public Names add(String name) {
        if (name != null) {
            this.names.add(name);
        }
        return this;
    }

    public Names remove(String name) {
        for (String s : this.names) {
            if (s.equals(name)) {
                this.names.remove(s);
                break;
            }
        }
        return this;
    }

    public Names sort(boolean alphabetically) {
        Comparator<String> comparator = alphabetically ? Names::sortAZ : Names::sortZA;
        return sort(comparator);
    }

    public Names sort(Comparator<String> comparator) {
        if (comparator == null) {
            return new Names();
        }
        return new Names(names.stream().sorted(comparator).collect(Collectors.toList()));
    }

    public Names sortAZ() {
        return sort(true);
    }

    public Names sortZA() {
        return sort(false);
    }

    public Names sort1ToLongest() {
        return sort(Names::sort1ToLongest);
    }

    public Names sortLongestTo1() {
        return sort(Names::sortLongestTo1);
    }

    public Names sort1ToInfinityAZ() {
        return new Names(names.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() > o2.length() ? 1 : -1;
            }
        }).collect(Collectors.toList()));
    }

    public Names sort1ToInfinityZA() {
        return new Names(names.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            } else {
                return o1.length() > o2.length() ? 1 : -1;
            }
        }).collect(Collectors.toList()));
    }

    public List<String> toList() {
        return new ArrayList<>(names);
    }

    @Nullable
    public String min() {
        return names.stream().min(String::compareTo).orElse(null);
    }

    @Nullable
    public String max() {
        return names.stream().max(String::compareTo).orElse(null);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        names.forEach(sj::add);
        return "Names:\n" + sj.toString() + "\n\n";
    }
}

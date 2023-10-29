package homework5;

import java.util.ArrayList;

public class Forks {
    private final ArrayList<Fork> forks = new ArrayList<>();

    public Forks(int count) {
        for (int i = 0; i < count; i++)
            forks.add(new Fork(i));
    }

    public Fork get(int index) {
        return forks.get(index);
    }
}
package homework5;

import java.util.ArrayList;
import java.util.List;

public class Philosophers {
    private List<Philosopher> philosophers = new ArrayList<>();

    public Philosophers(int count) {
        for (int i = 0; i < count; i++) {
            philosophers.add(new Philosopher("P" + i));
        }
    }

    public Philosopher get(int index) {
        return philosophers.get(index);
    }
}

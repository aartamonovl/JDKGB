package homework5;

import java.util.ArrayList;
import java.util.List;

public class Philosophers {
    private final List<Philosopher> philosophers = new ArrayList<>();

    public Philosophers(int count, Forks forks) {
        philosophers.add(new Philosopher("P0", forks.get(1), forks.get(0)));
        for (int i = 1; i < count; i++) {
            philosophers.add(new Philosopher("P" + i, forks.get(i), forks.get((i + 1) % count)));
        }
    }

    public void startAll() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
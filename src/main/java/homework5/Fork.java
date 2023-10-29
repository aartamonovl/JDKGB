package homework5;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int name;
    private final ReentrantLock rl = new ReentrantLock();

    public Fork(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "name=" + name +
                '}';
    }

    public void lock() {
        this.rl.lock();
    }

    public void unlock() {
        rl.unlock();
    }
}

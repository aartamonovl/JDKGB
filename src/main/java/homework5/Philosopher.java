package homework5;

import java.util.Random;

public class Philosopher extends Thread {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Random random = new Random();
    private int needEatCount = 3;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher " + name + " is eating");
        sleep(random.nextLong(0, 1) * 2000);
        downNeedEatCount();
    }

    public void think() throws InterruptedException {
        System.out.println("Philosopher " + name + " is thinking");
        sleep(random.nextLong(0, 1) * 2000);
    }

    private void downNeedEatCount() {
        System.out.println(name + " need eat " + --needEatCount + " times");
    }

    private void leaveFork(Fork fork) throws InterruptedException {
        sleep(500);
        fork.unlock();
        System.out.println(name + " put down fork named " + fork.getName());
    }

    @Override
    public void run() {
        while (needEatCount > 0) {
            try {
                think();
                takeFork(leftFork);
                takeFork(rightFork);
                eat();
                leaveFork(rightFork);
                leaveFork(leftFork);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void takeFork(Fork fork) throws InterruptedException {
        fork.lock();
        System.out.println(name + " take fork name: " + fork.getName());
        sleep(random.nextLong(0, 1) * 1000);
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "name='" + name + '\'' +
                '}';
    }
}

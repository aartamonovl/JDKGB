package homework5;

public class Philosopher extends Thread{
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private int needEatCount = 3;

    public Philosopher(String name) {
        this.name = name;
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher " + name + " is eating");
        sleep(1000);
        needEatCount--;
        leaveForks();
    }

    public void think() throws InterruptedException {
        System.out.println("Philosopher "  + name + " thinking");
        sleep(2000);
    }

    private void leaveForks() {
        leftFork = null;
        rightFork = null;
    }

    @Override
    public void run() {
        while (needEatCount > 0){
            if (leftFork != null){
                tryToTakeFork();
            }
        }
    }

    private boolean tryToTakeFork() {
        return false;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "name='" + name + '\'' +
                '}';
    }
}

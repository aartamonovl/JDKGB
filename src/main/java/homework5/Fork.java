package homework5;

public class Fork {
    private int name;

    public Fork(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void becomeBusy () throws InterruptedException {
        this.wait();
    }

    @Override
    public String toString() {
        return "Fork{" +
                "name=" + name +
                '}';
    }
}

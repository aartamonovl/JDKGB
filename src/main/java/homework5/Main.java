package homework5;

public class Main {
    public static void main(String[] args) {
        int count = 5;
        Forks forks = new Forks(count);
        Philosophers philosophers = new Philosophers(count, forks);
        philosophers.startAll();
    }
}
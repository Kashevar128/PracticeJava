package homeWork_03.counter;

public class Counter {

    private int count;

    private int limit;

    public Counter(int limit) {
        this.count = 0;
        this.limit = limit;
    }

    synchronized public int increment() {
        notify();
        count++;
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(count == 1000) notifyAll();
        return count;
    }

    public int getCount() {
        return count;
    }
}

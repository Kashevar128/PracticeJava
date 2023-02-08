package homeWork_03.counter;

public class MyThread implements Runnable{
    private Thread thread;
    private String nameThread;
    private Counter counter;

    public MyThread(String nameThread, Counter counter) {
        this.nameThread = nameThread;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() != 1000) {
            int c = counter.increment();
            System.out.println(c + " - " + nameThread);
        }
    }

    public void start() {
        thread = new Thread(this, nameThread);
        thread.start();
    }
}

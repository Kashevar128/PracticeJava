package homeWork_03.counter;

public class MainTestThread {
    public static void main(String[] args) {
        Counter counter = new Counter(1000);
        MyThread myThread_01 = new MyThread("Поток1", counter);
        MyThread myThread_02 = new MyThread("Поток2", counter);
        myThread_01.start();
        myThread_02.start();
    }
}

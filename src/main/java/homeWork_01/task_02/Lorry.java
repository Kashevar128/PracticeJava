package homeWork_01.task_02;

public class Lorry extends Car implements Moveable, Stopable{
    @Override
    void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is moving");
    }
}

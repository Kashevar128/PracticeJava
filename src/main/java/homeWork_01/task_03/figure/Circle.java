package homeWork_01.task_03.figure;

public class Circle extends Figure {
    @Override
    public void info() {
        System.out.println("Это круг");
    }

    @Override
    public void draw() {
        System.out.println("Круг нарисован!");
    }
}

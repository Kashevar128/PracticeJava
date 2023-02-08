package homeWork_01.task_03.figure;

public class Triangle extends Figure {
    @Override
    public void info() {
        System.out.println("Это треугольник");
    }

    @Override
    public void draw() {
        System.out.println("Треугольник нарисован!");
    }
}

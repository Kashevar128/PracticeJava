package homeWork_01.task_03.figure;

public class Square extends Figure {

    @Override
    public void info() {
        System.out.println("Это квадрат");
    }

    @Override
    public void draw() {
        System.out.println("Квадрат нарисован!");
    }
}

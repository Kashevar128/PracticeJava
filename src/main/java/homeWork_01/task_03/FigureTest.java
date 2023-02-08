package homeWork_01.task_03;

import homeWork_01.task_03.figure.Circle;
import homeWork_01.task_03.figure.Figure;
import homeWork_01.task_03.figure.Square;
import homeWork_01.task_03.figure.Triangle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FigureTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        List<Figure> figuresList = Arrays.asList(circle, square, triangle);

        Consumer<Figure> consumerInfo = (Figure::info);
        Consumer<Figure> consumerDraw = (Figure::draw);

        apply(consumerInfo, figuresList);
        apply(consumerDraw, figuresList);
    }

    private static void apply(Consumer<Figure> consumer, List<Figure> figuresList) {
        for (Figure figure : figuresList) {
            consumer.accept(figure);
        }
    }
}


import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();


        shapes.add(new Circle(5.0, "Red"));
        shapes.add(new Rectangle(4.0, 6.0, "Blue"));
        shapes.add(new Triangle(3.0, 8.0, "Green"));

        System.out.println("Shape Calculator with Colors\n");


        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " -> Area: " + shape.calculateArea());
        }
    }
}


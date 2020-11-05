package design_pattern.creational.factory.other_realization;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author chenyuqun
 */
public class ShapeFactory {
    final static Map<String, Supplier<Shape>> map = new HashMap<>();

    static {
        map.put("CIRCLE", Circle::new);
        map.put("RECTANGLE", Rectangle::new);
    }

    public static Shape getShape(String shapeType) {
        Supplier<Shape> shape = map.get(shapeType.toUpperCase());
        if (shape == null) {
            throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
        }
        return shape.get();
    }

    public static void main(String[] args) {
        Circle circle1 = (Circle) ShapeFactory.getShape("circle");
        Circle circle2 = (Circle) ShapeFactory.getShape("circle");
        System.out.println(circle1);
        System.out.println(circle2);
    }

}

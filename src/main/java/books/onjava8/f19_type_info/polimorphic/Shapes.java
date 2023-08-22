package books.onjava8.f19_type_info.polimorphic;

import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/5/12 4:24 下午
 */
public class Shapes {
    public static void main(String[] args) {
        Stream.of(new Circle(), new Square()).forEach(Shape::draw);
    }
}

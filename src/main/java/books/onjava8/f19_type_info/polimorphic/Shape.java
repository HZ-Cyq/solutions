package books.onjava8.f19_type_info.polimorphic;

/**
 * @author chenyuqun
 * @date 2021/5/12 4:22 下午
 */
public abstract class Shape {
    public void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

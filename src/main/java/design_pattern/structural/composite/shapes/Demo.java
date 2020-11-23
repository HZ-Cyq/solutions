package design_pattern.structural.composite.shapes;

import java.awt.*;

/**
 * 将对象组合成树状结构，并且能像使用独立对象一样使用他们。
 * 对于生成树结构的问题来说，组合是非常受欢迎的解决方案。
 * 主要的功能是在整个树结构上递归调用方法并对结果进行汇总
 *
 * @author chenyuqun
 * @date 2020/11/19 8:52 下午
 */
public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new ComponentShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new ComponentShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )

        );
    }
}


package design_pattern.structural.composite.shapes;

import java.awt.*;

/**
 * @author chenyuqun
 * @date 2020/11/19 8:52 下午
 */
public interface Shape {
    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void move(int x, int y);

    boolean isInsideBounds(int x, int y);

    void select();

    void unSelect();

    boolean isSelected();

    void paint(Graphics graphics);
}

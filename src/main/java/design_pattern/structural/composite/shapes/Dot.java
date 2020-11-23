package design_pattern.structural.composite.shapes;

import java.awt.*;

/**
 * @author chenyuqun
 * @date 2020/11/20 11:30 ����
 */
public class Dot extends BaseShape {
    private final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y- 1 ,getWidth(), getHeight());
    }
}

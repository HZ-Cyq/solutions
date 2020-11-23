package design_pattern.structural.composite.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2020/11/20 11:46 ����
 */
public class ComponentShape extends BaseShape {
    protected List<Shape> children = new ArrayList<>();

    public ComponentShape(Shape... components) {
        super(0,0,Color.BLACK);
        add(components);
    }

    public void add(Shape component) {
        children.add(component);
    }

    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Shape child) {
        children.remove(child);
    }

    public void remove(Shape... components) {
        children.remove(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
//        if(children.size() == 0) {
//            return 0;
//        }
//        int x = children.get(0).getX();
//        for (Shape child : children) {
//            if(child.getX() < x) {
//                x = child.getX();
//            }
//        }
//        return x;
        return children.stream().mapToInt(Shape::getX).reduce(0, Math::min);
    }

    @Override
    public int getY() {
//        if(children.size() == 0) {
//            return 0;
//        }
//        int y = children.get(0).getY();
//        for (Shape child : children) {
//            if(child.getY() < y) {
//                y = child.getY();
//            }
//        }
//        return y;
        return children.stream().mapToInt(Shape::getY).reduce(0, Math::min);
    }

    @Override
    public int getWidth() {
//        int maxWidth = 0;
//        int x = getX();
//        for (Shape child : children) {
//            int childRelativeX = child.getX() - x;
//            int childWidth = childRelativeX + child.getWidth();
//            if(childWidth > maxWidth) {
//                maxWidth = childWidth;
//            }
//
//        }
//        return maxWidth;
        int x = getX();
        int maxX = children.stream().mapToInt(child -> child.getX() - x + child.getWidth()).max().orElse(0);
        return maxX;
    }

    @Override
    public int getHeight() {
//        int maxHeight = 0;
//        int y = getY();
//        for (Shape child : children) {
//            int childsRelativeY = child.getY() - y;
//            int childHeight = childsRelativeY + child.getHeight();
//            if(childHeight > maxHeight) {
//                maxHeight = childHeight;
//            }
//        }
//        return maxHeight;
        int y = getY();
        int maxY = children.stream().mapToInt(child -> child.getY() - y + child.getHeight()).max().orElse(0);
        return maxY;
    }

    @Override
    public void move(int x, int y) {
        children.forEach(child -> child.move(x, y));
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return children.stream().allMatch(child -> child.isInsideBounds(x, y));
    }

    @Override
    public void unSelect() {
        super.unSelect();

    }

    public boolean selectChildAt(int x, int y) {
        for (Shape child : children) {
            if(child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        if(isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1 , getY() - 1, getWidth() + 1 , getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (Shape child : children) {
            child.paint(graphics);
        }
    }
}

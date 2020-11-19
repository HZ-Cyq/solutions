package design_pattern.structural.adapter.round_and_square;

/**
 * @author chenyuqun
 * @date 2020/11/19 11:14 上午
 */
public class RoundPeg {
    private double radius;

    public RoundPeg() {
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

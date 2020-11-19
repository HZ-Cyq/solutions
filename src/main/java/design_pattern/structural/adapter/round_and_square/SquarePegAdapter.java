package design_pattern.structural.adapter.round_and_square;

/**
 * @author chenyuqun
 * @date 2020/11/19 11:19 上午
 */
public class SquarePegAdapter extends RoundPeg {
    private SquareReg squareReg;

    public SquarePegAdapter(SquareReg squareReg) {
        this.squareReg = squareReg;
    }

    @Override
    public double getRadius() {
        // with / √2
        return squareReg.getWidth() / Math.pow(2, 0.5);
    }

    public SquareReg getSquareReg() {
        return squareReg;
    }

    public void setSquareReg(SquareReg squareReg) {
        this.squareReg = squareReg;
    }
}

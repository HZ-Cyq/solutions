package design_pattern.structural.adapter.round_and_square;

/**
 * 让方钉配圆孔：让不兼容的对象相互合作
 *
 * @author chenyuqun
 * @date 2020/11/19 10:54 上午
 */
public class Demo {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        SquareReg squareReg1 = new SquareReg(1.0);
        SquareReg squareReg2 = new SquareReg(20.0);
        SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(squareReg1);
        SquarePegAdapter squarePegAdapter2 = new SquarePegAdapter(squareReg2);
        System.out.println(roundHole.fits(squarePegAdapter1));
        System.out.println(roundHole.fits(squarePegAdapter2));
    }
}

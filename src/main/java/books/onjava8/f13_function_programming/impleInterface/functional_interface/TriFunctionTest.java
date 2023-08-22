package books.onjava8.f13_function_programming.impleInterface.functional_interface;

/**
 * @author chenyuqun
 * @date 2021/5/31 2:12 下午
 */
public class TriFunctionTest {
    public static int f(int i, long l, double d) {
        return 11;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> triFunction = TriFunctionTest::f;
        System.out.println(triFunction.apply(1, 2L, 3D));
    }
}

package books.onjava8.f13_function_programming.impleInterface.function_composition;

import java.util.function.Function;

/**
 * @author chenyuqun
 * @date 2021/5/31 6:03 下午
 */
public class FunctionCompose {
    public static void main(String[] args) {
        Function<Integer, Integer> addOne = a -> a + 1;
        Function<Integer, Integer> multiTwo = a -> a * 2;
        Function<Integer, Integer> compose = addOne.compose(multiTwo);
        System.out.println(compose.apply(4));
    }
}

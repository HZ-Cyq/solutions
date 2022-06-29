package onjava8.f13_function_programming.impleInterface.function_composition;

import java.util.function.Function;

/**
 * @author chenyuqun
 * @date 2021/5/31 5:41 下午
 */
public class FunctionAddThen {

    public static void main(String[] args) throws Throwable {
        Function<Integer, Integer> addOne = a -> a + 1;
        Function<Integer, Integer> multiTwo = a -> a * 2;
        Function<Integer, Integer> compose = addOne.andThen(multiTwo);
        System.out.println(compose.apply(4));
    }
}

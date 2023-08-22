package books.onjava8.f13_function_programming.impleInterface.closure;

import java.util.function.IntSupplier;

/**
 * @author chenyuqun
 * @date 2021/5/31 3:21 下午
 */
public class Closure1 {
    int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}

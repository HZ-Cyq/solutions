package onjava8.f13_function_programming.impleInterface.closure.local_variable;

import java.util.function.IntSupplier;

/**
 * @author chenyuqun
 * @date 2021/5/31 3:43 下午
 */
public class Closure2Test {
    public static void main(String[] args) {
        Closure2 closure2 = new Closure2();
        System.out.println("init intSupplier");
        IntSupplier intSupplier = closure2.makeFun(1);
        System.out.println("init intSupplier2");
        IntSupplier intSupplier1 = closure2.makeFun(1);

        System.out.println(intSupplier.getAsInt());
        System.out.println(intSupplier1.getAsInt());
    }
}

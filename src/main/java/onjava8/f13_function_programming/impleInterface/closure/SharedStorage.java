package onjava8.f13_function_programming.impleInterface.closure;

import java.util.function.IntSupplier;

/**
 * @author chenyuqun
 * @date 2021/5/31 3:23 下午
 */
public class SharedStorage {
    public static void main(String[] args) {
        // 通过Closure1创建了三个supplier,这三个supplier共享closure1的i
        Closure1 closure1 = new Closure1();
        IntSupplier intSupplier = closure1.makeFun(0);
        IntSupplier intSupplier1 = closure1.makeFun(0);
        IntSupplier intSupplier2 = closure1.makeFun(0);

        System.out.println(intSupplier.getAsInt());
        System.out.println(intSupplier1.getAsInt());
        System.out.println(intSupplier2.getAsInt());

    }
}

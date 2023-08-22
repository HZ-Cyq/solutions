package books.onjava8.f13_function_programming.impleInterface.closure.local_variable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @author chenyuqun
 * @date 2021/5/31 3:29 下午
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        System.out.println("i: " + i);
        return () -> x;
        // 下面这行会报错，因为被Lambda表达式引用的局部变量必须是final或者是等同final效果的。
        //return () -> i + x;
    }

    Supplier<List<Integer>> makeFun1(int x) {
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.clear();
        return () -> list;
    }

    public void a() {
        final byte b = 1;
        final short s = 1;
        final int i = 1;
        final long l = 1;

        final boolean bool = false;
        final char c = 's';
        final float f = 1F;
        final double d = 1D;


        final Byte by = 1;
        final Short sh = 1;
        final Integer in = 1;
        final Long lo = 1L;

        final Boolean boo = false;
        final Character ch = 'a';
        final Float fl = 1F;
        final Double dou = 1D;
        //        下面会报错
//        b = 1;
//        s = 1;
//        i = 1;
//        l = 1;
//        bool = false;
//        c = 's';
//        f = 1F;
//        d = 1D;
//        by = 1;
//        sh = 1;
//        in = 1;
//        lo = 1L;
//        boo = false;
//        ch = 'b';
//        fl = 1F;
//        dou = 1D;
    }
}

package innerclass.test;

import org.junit.Test;

/**
 * @author chenyuqun
 * @date 2022/1/20 3:36 下午
 */
public class Test1 {
    interface Inner {
        void show();
    }

    static class Outer {
        // 问题：补充, 输出HelloWorld 将 /** */ 注释删掉
    }

    @Test
    public void test() {
        /** Outer.method().show(); */
    }
    // 答案
    //    public static Inner method() {
    //        return () -> System.out.println("HelloWorld");
    //    }
}

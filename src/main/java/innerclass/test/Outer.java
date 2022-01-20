package innerclass.test;

import org.junit.Test;

/**
 * @author chenyuqun
 * @date 2022/1/20 3:27 下午
 */
public class Outer {
    public int num = 10;
    class Inner {
        int num = 20;
        void show() {
            int num = 30;
            // 问题：填入什么，输出 10, 20, 30
//            System.out.println(???);
//            System.out.println(???);
//            System.out.println(???);
        }
    }
    @Test
    public void test() {
        Outer.Inner inner = new Outer.Inner();
        inner.show();
    }
    // 答案：Outer.this.num、this.num、num
}

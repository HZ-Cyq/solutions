package java_language_basic.language_basic;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class SwitchTest {
    /**
     * switch语句只能用作相等比较，value取值只能是整数类型或者字符类型
     */
    @Test
    public void testSwitch() {
        int a = 1;
        char b = '1';
        long c = 1L;
        switch (a) {
            case 1: System.out.println(1);
        }
        switch (b) {
            case '1' : System.out.println('1');
        }
        // 下面的代码会报错
        /*switch (c) {
            case 1L: System.out.println(1L);
        }*/
    }
}

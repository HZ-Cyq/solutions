package java_language_basic.language_basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author playcrab_chenyuqun
 */
public class MyTest {

    @Test
    public void testMyException() {
         int month = 13;
         try {
             if(month < 1 || month > 12) {
                throw new MyException("月份超过了实际的数值");
             } else {
                System.out.println("当前的月份是" + month + "月");
             }
         } catch (MyException e) {
             System.err.println(e.toString());
         }
    }

    @Test
    public void testException() {
        try {
            throwException();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            System.out.println("exception");
            exception.printStackTrace();
        }
    }

    @Test
    public void testLong() {
        Long a = 10000000000000L;
        Long b = 300L;
        double re = a * 1.0 / b;
        System.out.println(re);
    }

    @Test
    public void testFloor() {
        double a = 1.003;
        System.out.println("向上取整" + (int)Math.ceil(a));
        System.out.println("向下取整" + (int)Math.floor(a));
    }

    private void throwException() throws MyException {
        throw new MyException("throw a Exception");
    }
}

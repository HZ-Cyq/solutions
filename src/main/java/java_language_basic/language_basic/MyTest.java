package java_language_basic.language_basic;

import org.junit.Test;

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
        }
    }

    private void throwException() throws MyException {
        throw new MyException("throw a Exception");
    }
}

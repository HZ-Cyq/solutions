package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        try {
            method();
        } catch (MyException e) {
            // 打印描述信息
            logger.error(e.getDesc(), e.getErrorCode(), e.getObjects());
            // 打印堆栈信息
            logger.error(e.getMessage(), e);
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
        }
        System.out.println("hello world");
    }

    public static void method() throws MyException {
        Object obj = null;
        System.out.println(obj.hashCode());
    }
}

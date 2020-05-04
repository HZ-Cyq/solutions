package java_language_basic.language_basic;

/**
 * @author playcrab_chenyuqun
 */
public class MyException extends Exception{
    MyException(String msg) {
        super(msg);
        System.out.println("create a MyException");
    }
}

package test;

/**
 * @author chenyuqun
 */
public class OtherTest {


    public static void main(String[] args) {
        A a = new A();
        A b = a;
        b.setA(2);
        System.out.println(a.getA());
    }
}

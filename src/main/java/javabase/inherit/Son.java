package javabase.inherit;

/**
 * @author playcrab_chenyuqun
 */
public class Son extends Father {

    public Son(int a) {
        System.out.println(a);
    }

    static {
        System.out.println("static method in son");
    }

    {
        System.out.println("object method in son");
    }
}

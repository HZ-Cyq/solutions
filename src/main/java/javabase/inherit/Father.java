package javabase.inherit;

/**
 * @author playcrab_chenyuqun
 */
public class Father {

    static {
        System.out.println("static method in father");
    }

    {
        System.out.println("object method in father");
    }

    public Father() {
        System.out.println("father constructor");
    }
}

package kkb.jvm;

/**
 * @author chenyuqun
 * @date 2021/5/18 4:24 下午
 */
public class A {
    static {
        System.out.println("static code block");
    }

    {
        System.out.println("code block");
    }
}

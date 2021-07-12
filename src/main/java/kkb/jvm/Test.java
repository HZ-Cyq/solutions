package kkb.jvm;

/**
 * @author chenyuqun
 * @date 2021/5/18 4:24 下午
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("before forName");
        Class<?> cla = Class.forName("kkb.jvm.A");
        System.out.println("foName end");

        System.out.println("before newInstance");
        Object o1 = cla.newInstance();
        Object o2 = cla.newInstance();
        System.out.println("newInstance end");

        System.out.println(o1);
        System.out.println(o2);
    }
}

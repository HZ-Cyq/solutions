package javabase.inherit.testinterface;

/**
 * @author playcrab_chenyuqun
 */
public interface Interface {
    // 接口的默认实现方式
    default void printHello() {
        System.out.println("hello");
    }
}

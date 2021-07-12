package onjava8.f19_type_info._interface._method;

import java.lang.reflect.Method;

/**
 * 测试getMethods方法和getDeclaredMethods方法
 *
 * @author chenyuqun
 * @date 2021/5/20 9:24 下午
 */
public class Main {
    public static void main(String[] args) {
        printMethods("getMethods", Distribution.class.getMethods());
        printMethods("getDeclaredMethods", Distribution.class.getDeclaredMethods());
    }

    public static void printMethods(String desc, Method[] methods) {
        System.out.println(desc + ":");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println();
    }
}

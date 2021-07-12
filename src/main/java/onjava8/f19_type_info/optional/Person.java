package onjava8.f19_type_info.optional;

import java.util.Optional;

/**
 * @author chenyuqun
 * @date 2021/5/20 4:09 下午
 */
public class Person {
    public final String first = "";
    public static void main(String[] args) {
        String val = null;
        String str = Optional.ofNullable(val).orElse("hello");
        System.out.println(str);
    }
}

package books.onjava8.f19_type_info.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author chenyuqun
 * @date 2021/5/19 3:53 下午
 */
public class ShowMethods {
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
        Class<?> c = ShowMethods.class;
        for (Method method : c.getMethods()) {
            System.out.println(p.matcher(method.toString()).replaceAll(""));
        }
        System.out.println();
        for (Constructor<?> constructor : c.getConstructors()) {
            System.out.println(p.matcher(constructor.toString()).replaceAll(""));
        }
    }

}

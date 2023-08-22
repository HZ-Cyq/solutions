package books.onjava8.f13_function_programming.impleInterface.currying;

import java.util.function.Function;

/**
 * @author chenyuqun
 * @date 2021/5/31 6:33 下午
 */
public class CurryingAndPartials {
    /**
     * 没有柯里化的方法
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String add(String str1, String str2) {
        return str1 + str2;
    }

    public static void main(String[] args) {
        // 柯里化的方法
        Function<String, Function<String, String>> currying = str1 -> (str2 -> str1 + str2);
        // 先确定第一个参数str1,这里的hello函数相当于是部分应用
        Function<String, String> hello = currying.apply("hello, ");
        // 再确定第二个参数
        System.out.println(hello.apply("world"));
        System.out.println(hello.apply("java"));
    }
}

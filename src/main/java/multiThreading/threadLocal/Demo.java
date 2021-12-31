package multiThreading.threadLocal;

/**
 * @author chenyuqun
 * @date 2021/11/2 2:23 下午
 */
public class Demo {
    private static ThreadLocal<String> ctx = new ThreadLocal<>();
    public static void main(String[] args) {
        ctx.set("hello");
        ctx.remove();
    }
}

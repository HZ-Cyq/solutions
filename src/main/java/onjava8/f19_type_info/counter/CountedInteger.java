package onjava8.f19_type_info.counter;

/**
 * @author chenyuqun
 * @date 2021/5/17 1:34 下午
 */
public class CountedInteger {
    public static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "" + id;
    }
}

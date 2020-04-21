package generics.sgenerics.limitType;

/**
 * 限定泛型方法的类型
 * @author playcrab_chenyuqun
 */
public class LimitTypeFoMethod {

    public static <T extends Comparable> T getMin(T t1, T t2) {
        return (t1.compareTo(t2) < 0)? t1: t2;
    }

}

package books.onjava8.f19_type_info.initialization;

/**
 * @author chenyuqun
 * @date 2021/5/13 3:03 下午
 */
public class Initable {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable");
    }
}

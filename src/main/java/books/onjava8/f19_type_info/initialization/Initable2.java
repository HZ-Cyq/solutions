package books.onjava8.f19_type_info.initialization;

/**
 * @author chenyuqun
 * @date 2021/5/13 3:00 下午
 */
public class Initable2 {
    // 编译期常量，不会初始化类
    static final int STATIC_FINAL = 47;
    // 运行时常量，会初始化类
    static final int STATIC_FINAL2 = "1234".length();

    static {
        System.out.println("Initializing Initable2");
    }
}

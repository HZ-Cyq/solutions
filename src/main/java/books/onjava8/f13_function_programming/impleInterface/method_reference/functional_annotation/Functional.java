package books.onjava8.f13_function_programming.impleInterface.method_reference.functional_annotation;

/**
 * @author chenyuqun
 * @date 2021/5/28 4:50 下午
 */
@FunctionalInterface
public interface Functional {
    String goodbye(String arg);
    default String apply(String arg) {
        return goodbye(arg);
    }
//    String hello(Strin g arg);
}

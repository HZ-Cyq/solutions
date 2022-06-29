package onjava8.f13_function_programming.impleInterface.functional_interface;

/**
 * @author chenyuqun
 * @date 2021/5/31 11:50 上午
 */
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t,U u,V v);
}

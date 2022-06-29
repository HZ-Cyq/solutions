package onjava8.f14_stream.intermediate_opration;

import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/6/17 2:39 下午
 */
public class FunctionMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).map(i -> Stream.of("hello", "world")).forEach(System.out::println);
        // flatMap：将产生流的函数应用在每个元素上（与map()所做的相同），然后将每个流都偏平化为元素，因而最终产生的仅仅是元素
        Stream.of(1, 2, 3).flatMap(i -> Stream.of("hello", "world")).forEach(System.out::println);
    }
}

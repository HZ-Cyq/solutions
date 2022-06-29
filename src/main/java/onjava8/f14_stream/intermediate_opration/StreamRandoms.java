package onjava8.f14_stream.intermediate_opration;

import java.util.stream.IntStream;

/**
 * @author chenyuqun
 * @date 2021/6/17 4:27 下午
 */
public class StreamRandoms {
    public static void main(String[] args) {
        // concat可以组合两个流
        IntStream.concat(IntStream.range(0,10), IntStream.range(90,100)).forEach(System.out::println);
    }
}

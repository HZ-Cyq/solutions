package onjava8.f14_stream;

import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/6/16 11:30 上午
 */
public class Fabonacci {
    private int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fabonacci().numbers().limit(10).forEach(System.out::println);
    }
}

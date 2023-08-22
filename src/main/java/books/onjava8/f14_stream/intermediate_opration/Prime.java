package books.onjava8.f14_stream.intermediate_opration;

import java.util.stream.LongStream;

/**
 * @author chenyuqun
 * @date 2021/6/17 2:31 下午
 */
public class Prime {
    public static boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1);
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        prime.numbers().limit(100).filter(Prime::isPrime).forEach(System.out::println);
    }
}

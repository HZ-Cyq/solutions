package books.onjava8.f14_stream;

import java.util.Random;

/**
 * @author chenyuqun
 * @date 2021/6/15 4:31 下午
 */
public class Randoms {
    public static void main(String[] args) {
        new Random(47).ints(5, 20).distinct().limit(7).sorted().forEach(System.out::println);
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}

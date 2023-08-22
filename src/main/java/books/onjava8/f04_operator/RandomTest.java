package books.onjava8.f04_operator;

import org.junit.Test;

import java.util.Random;

/**
 * @author chenyuqun
 * @date 2021/5/9 12:09 下午
 */
public class RandomTest {
    @Test
    public void testRandom() {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100) + 1);
        }
    }
}

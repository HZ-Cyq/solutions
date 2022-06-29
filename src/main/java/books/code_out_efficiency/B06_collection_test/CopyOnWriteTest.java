package books.code_out_efficiency.B06_collection_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenyuqun
 * @date 2022/3/4 10:29 上午
 */
public class CopyOnWriteTest {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 20 * 10000; i++) {
            list.add(System.nanoTime());
        }
        List<Long> copy = new CopyOnWriteArrayList<>(list);
        long finish = System.nanoTime();
        System.out.println((finish - start) / (1000 * 1000 * 1000.0) + "s");
    }
}

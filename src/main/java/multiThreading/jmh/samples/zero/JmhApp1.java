package multiThreading.jmh.samples.zero;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/8
 */
public class JmhApp1 {

    private static void test(List<String> list) {
        // 执行list.add操作的次数
        int addCount = 1000000;
        for (int i = 0; i < addCount; i++) {
            list.add("测试数据");
        }
    }

    /**
     * ArrayList性能测试
     * @param iterations 迭代（循环）次数
     */
    private static void arrayListPerfTest(int iterations) {
        for (int i = iterations; i > 0; i--) {
            ArrayList<String> list = new ArrayList<>();
            Stopwatch stopwatch = Stopwatch.createStarted();
            test(list);
            System.out.printf("ArrayList第%d次循环add操作， 消耗时间为：%d毫秒\n", i + 1, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    private static void linkedListPerfTest(int iterations) {
        for (int i = 0; i < iterations; i++) {
            List<String> list = new LinkedList<>();
            Stopwatch stopwatch = Stopwatch.createStarted();
            test(list);
            System.out.printf("LinkedList第%d次循环add操作， 消耗时间为：%d毫秒\n", i + 1, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    public static void main(String[] args) {
        int iterations = 10;
        arrayListPerfTest(iterations);
        System.out.println(Strings.repeat("#", 48));
        linkedListPerfTest(iterations);
    }
}

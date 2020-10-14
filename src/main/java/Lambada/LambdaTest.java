package Lambada;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8的Lambda表达式和处理
 * https://developer.ibm.com/zh/articles/j-understanding-functional-programming-3/
 *
 * @author chenyuqun
 */
public class LambdaTest {
    Integer[] array = new Integer[]{7, 7, 1, 2, 3, 4, 5, 6};

    // 如果再次对steam操作，会报错
    Supplier<Stream<Integer>> streamSupplier = () -> (Stream<Integer>) Arrays.stream(array);

    @Test
    public void testNewThread() {
        new Thread(() -> System.out.println("hello")).start();
    }

    /**
     * 测试中间操作:map,flatMap,filter,distinct,limit,skip,sorted,peek,dropWhile,takeWhile
     */
    @Test
    public void testIntermediate() {
        System.out.println("test map");
        Arrays.stream(array).map(ele -> ele + 1).forEach(printConsumer());
        System.out.println();
        streamSupplier.get().flatMap(ele -> Stream.of(ele + 2)).forEach(printConsumer());
        System.out.println();
        //通过streamSupplier的get，多次使用也不会报错
        streamSupplier.get().map(ele -> ele + 3).forEach(printConsumer());

        System.out.println("\ntest filter");
        streamSupplier.get().filter(ele -> ele != 7).forEach(printConsumer());

        System.out.println("\ntest distinct");
        streamSupplier.get().distinct().forEach(printConsumer());

        System.out.println("\ntest skip");
        streamSupplier.get().skip(2).forEach(printConsumer());

        System.out.print("\ntest peek");
        final int[] a = {0};
        streamSupplier.get().peek(ele -> {
            a[0]++;
        }).forEach(printConsumer());
        System.out.println("a[0]: " + a[0]);
    }

    @Test
    public void testTerminal() {
        System.out.println("test reduce");
        streamSupplier.get().reduce((ele1, ele2) -> ele1 + ele2).ifPresent(printConsumer());

        System.out.println("\ntest collect");
        Map<Character, List<String>> names = Stream.of("Alex", "Bob", "David", "Amy")
                .collect(Collectors.groupingBy(v -> v.charAt(0)));
        System.out.println(names);

        System.out.println("\ntest joining");
        String str = Stream.of("a", "b", "c")
                .collect(Collectors.joining(", "));
        System.out.println(str);

        System.out.println("\ntest averagingInt");
        double avgLength = Stream.of("hello", "world", "a")
                .collect(Collectors.averagingInt(String::length));
        System.out.println(avgLength);

        // 与数学计算相关的收集器
        System.out.println("\ntest summarizingInt");
        final IntSummaryStatistics statistics = Stream.of("a", "hijklmn", "b", "cd", "efg", "qdeddcee")
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());

    }

    private <T> Consumer<T> printConsumer() {
        return t -> System.out.print(t + ",");
    }

    @Test
    public void testFP() {
        Optional result = Stream.of("f", "ba", "hello").map(s -> s.length()).filter(l -> l <= 3).max((o1, o2) -> o1 - o2);
        System.out.println(result.get()); // 输出2
    }

    @Test
    public void test1() {
        // 在map1中找最大value对应的key,如果有多个key,再去map2中找最大value对应的key.
        Map<String, Long> map1 = Maps.newHashMap();
        map1.put("1", 1L);
        map1.put("2", 2L);
        map1.put("3", 3L);
        map1.put("4", 3L);

        Map<String, Long> map2 = Maps.newHashMap();
        map2.put("1", 1L);
        map2.put("2", 2L);
        map2.put("3", 3L);
        map2.put("4", 4L);

        List<Map.Entry<String, Long>> list = Lists.newArrayList(map1.entrySet());

        Collections.sort(list, (o1, o2) -> {
            // 返回值小于0，不交换顺序，是正常的.意思是说我希望o1的值小于o2
            if (o1.getValue() < o2.getValue()) {
                return -1;
            }
            return 1;
        });
        System.out.println(list);
    }

    @Test
    public void test2() {
        List<Integer> list = Lists.newArrayList();
        /*list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);*/
        /*int max = list.stream().max((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            }
            return 1;
        }).get();
        System.out.println(max);*/

        System.out.println(list.stream().reduce(Integer::sum).orElse(0));
    }

//    @Test

    public void change(Integer i, Integer j) {
        i = 1;
        j = 2;
    }

}

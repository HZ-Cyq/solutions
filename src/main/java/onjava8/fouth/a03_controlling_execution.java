package onjava8.fouth;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * @author chenyuqun
 * @date 2021/6/26 2:56 下午
 */
public class a03_controlling_execution {

    @Test
    public void test1() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ", ");
        }
    }

    @Test
    public void test2() {
        List<Integer> less = Lists.newArrayList();
        List<Integer> greater = Lists.newArrayList();
        List<Integer> equal = Lists.newArrayList();
        List<Integer> randoms = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            randoms.add(random.nextInt(10));
        }
        for (int i = 0; i < randoms.size() - 1; i++) {
            if (randoms.get(i) < randoms.get(i + 1)) {
                less.add(randoms.get(i));
            } else if (randoms.get(i) > randoms.get(i + 1)) {
                greater.add(randoms.get(i));
            } else {
                equal.add(randoms.get(i));
            }
        }
        System.out.println("randoms: ");
        randoms.forEach(ele -> System.out.print(ele + ", "));
        System.out.println("\nless: ");
        less.forEach(ele -> System.out.print(ele + ", "));
        System.out.println("\ngreater: ");
        greater.forEach(ele -> System.out.print(ele + ", "));
        System.out.println("\nequal: ");
        equal.forEach(ele -> System.out.print(ele + ", "));
    }

    @Test
    public void test3() {
        while (true) {
            test2();
        }
    }

    @Test
    public void test4() {
        for (int i = 2; i <= 100; i++) {
            boolean hasDivisor = false;
            for (int j = 2; j <= ((int) Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    hasDivisor = true;
                    break;
                }
            }
            if (!hasDivisor) {
                System.out.println(i + ",");
            }
        }
    }

    @Test
    public void test5() {
        int i = 1 + 4 + 16 + 64 + 256;
        int j = 2 + 8 + 32 + 128;
        System.out.println("i: " + Integer.toBinaryString(i));
        System.out.println("j: " + Integer.toBinaryString(j));
    }

    @Test
    public void test6() {
        List<String> list = Lists.newArrayList();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("yn");
        String s = list.stream().reduce((ele1, ele2) -> ele1 + "#" + ele2).orElseGet(null);
        System.out.println(s);
    }
}

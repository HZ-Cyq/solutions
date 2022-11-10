package jvm.zy;

import com.google.common.collect.Lists;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(100 * (21 / 1000F));
    }

    @Test
    public void test1() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(random(10));
//        }
//        HashMap<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "2");
//        System.out.println(map);
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.stream().reduce(Integer::sum));
    }

    private static int random(int min) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(min);
    }
}

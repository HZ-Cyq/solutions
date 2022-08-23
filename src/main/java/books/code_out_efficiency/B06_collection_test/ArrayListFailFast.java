package books.code_out_efficiency.B06_collection_test;

import org.junit.Test;

import java.util.*;

/**
 * @author chenyuqun
 * @date 2022/3/3 4:31 下午
 */
public class ArrayListFailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            list.add("six");
        }
    }

    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Thread thread1 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });
        Thread thread2 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });
    }

}

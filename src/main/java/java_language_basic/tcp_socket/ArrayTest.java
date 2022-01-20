package java_language_basic.tcp_socket;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * @author chenyuqun
 * @date 2020/11/13 1:52 下午
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[2];
        System.out.println(array.length);
        array[0] = 1;
        array[1] = 2;
        for (int value : array) {
            System.out.println(value);
        }

    }

    @Test
    public void testArray() {
        Set<String> set = Sets.newHashSet();
        set.add("123");
        set.add("456");
        String[] array = new String[set.size() + 1];
        set.toArray(array);
        array[set.size()] = "789";
        System.out.println(array);
    }

}

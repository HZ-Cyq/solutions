package books.code_out_efficiency.B06_collection_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

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
            if(next.equals("two")) {
                iterator.remove();
            }
        }
    }

    @Test
    public void test() {
        BitSet bitSet = new BitSet(5);
        bitSet.set(1);
        bitSet.set(3);
        for (int i = 0; i < 5; i++) {
            System.out.println(bitSet.nextSetBit(i));
        }
    }
}

package javabase.map.rangemap;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class RangeMapTest {
    @Test
    public void test1() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 2), "111");
        rangeMap.put(Range.closed(3, 4), "222");
        rangeMap.put(Range.closedOpen(5, 6), "333");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + rangeMap.get(i));
        }
    }
    @Test
    public void test2() {
        int i = 0;
        System.out.println(i++);
    }

    @Test
    public void test3() {
        int a = 3;
        switch (a) {
            case 1:
                System.out.println("case 1 print");
            case 2:
                System.out.println("case 2 print");
                break;
            case 3:
                System.out.println("case 3 print");
            case 4:
                System.out.println("case 4 print");
            case 5:
                System.out.println("case 5 print");
        }
    }
}

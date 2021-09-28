package javabase.set;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author chenyuqun
 * @date 2021/8/20 3:23 下午
 */
public class BitTest {
    @Test
    public void testBit() {

    }

    // 比如有一个long类型的数l
    // 判断1有没有
    @Test
    public void testLong() {
        long allOccupy = -1L;
        long[] allVal = new long[64];
        // init allVal
        for (int i = 0; i < allVal.length; i++) {
            allVal[i] = (long) Math.pow(2, i);
        }
        // 一个long有8字节，64位，表示256位bit信息需要4个long
        long[] array = new long[4];
        int index = -1;
        start:
        for (int i = 0; i < array.length; i++) {
            if (allOccupy == array[i]) continue;
            for (int j = 0; j < allVal.length; j++) {
                if ((allVal[j] & array[i]) != 0) continue;
                index = i * 64 + j;
                break start;
            }
        }
        System.out.println(index);
    }

    /**
     * 用1位表示某个数字是否出现过
     * 比如加进一个1，0001
     * 比如加进一个2，0011
     * 比如加进一个3，0111
     * 比如加进一个4，1111
     */
    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(3);
        bitSet.set(5);
        bitSet.set(3);
        System.out.println(bitSet.cardinality());
    }
}

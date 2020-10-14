package javabase.tuple;

import io.vavr.Tuple2;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class TupleTest {
    @Test
    public void test1() {
        Tuple2<Integer, Integer> tuple2 = new Tuple2<>(1, 2);
        tuple2 = tuple2.update1(2);
        tuple2 = tuple2.update2(1);
        System.out.println(tuple2._1);
        System.out.println(tuple2._2);
    }
}

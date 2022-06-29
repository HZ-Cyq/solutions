package books.code_out_efficiency.B06_collection_test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyuqun
 * @date 2022/2/28 5:39 下午
 */
public class ToArraySpeedTest {
    public static int COUNT = 100 * 100 * 100;

    public static double DIV = 1000.0 * 1000.0;

    public static int TEST_COUNT = 100;

    public static void main(String[] args) {
        double notEnoughTimes = 0.0;
        double equalTimes = 0.0;
        double doubleTimes = 0.0;
        for (int j = 0; j < TEST_COUNT; j++) {
            List<String> list = Lists.newArrayList();
            for (int i = 0; i < COUNT; i++) {
                list.add(String.valueOf(i));
            }

            String[] notEnoughArray = new String[COUNT - 1];
            String[] equalArray = new String[COUNT];
            String[] doubleArray = new String[COUNT * 2];

            long time1 = System.nanoTime();
            list.toArray(notEnoughArray);
            long time2 = System.nanoTime();
            list.toArray(equalArray);
            long time3 = System.nanoTime();
            list.toArray(doubleArray);
            long time4 = System.nanoTime();
            notEnoughTimes += ((time2 - time1) / DIV);
            equalTimes += ((time3 - time2) / DIV);
            doubleTimes += ((time4 - time3) / DIV);
        }
        System.out.println("not enough: " + notEnoughTimes / TEST_COUNT);
        System.out.println("equal: " + equalTimes / TEST_COUNT);
        System.out.println("double: " + doubleTimes / TEST_COUNT);
    }
}

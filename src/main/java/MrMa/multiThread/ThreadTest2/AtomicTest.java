package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author chenyuqun
 * @date 2020/12/3 8:47 上午
 */
public class AtomicTest {
    // 还可以用Sync和LongAdder
    // LongAdder,分段锁，适用于高并发。线程数少的话，LongAdder没有优势
    // TODO LongAdder的分段锁是怎么一回事儿
    static AtomicLong atomicLong = new AtomicLong(0L);
    static LongAdder longAdder = new LongAdder();
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    atomicLong.incrementAndGet();
                }
            });
            thread.start();
        }
        System.out.println("atomicLong: " + atomicLong.get());
    }
}

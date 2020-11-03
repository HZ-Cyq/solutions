package design_pattern.creational.singleton.realization.cluster;

import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenyuqun
 */
public class IdGeneratorThreadOnly {
    private AtomicLong id = new AtomicLong(0);
    public static final ConcurrentMap<Long, IdGeneratorThreadOnly> map = Maps.newConcurrentMap();

    private IdGeneratorThreadOnly() {

    }

    public static IdGeneratorThreadOnly getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        map.putIfAbsent(currentThreadId, new IdGeneratorThreadOnly());
        return map.get(currentThreadId);
    }

    public long getId() {
        return id.getAndIncrement();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                long id = getInstance().getId();
                System.out.println(Thread.currentThread().getName() + ":" + id);
                if (id != i) {
                    System.out.printf("thread name: %s, id: %d, i: %d", Thread.currentThread().getName(), id, i);
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                long id = getInstance().getId();
                System.out.println(Thread.currentThread().getName() + ":" + id);
                if (id != i) {
                    System.out.printf("thread name: %s, id: %d, i: %d", Thread.currentThread().getName(), id, i);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

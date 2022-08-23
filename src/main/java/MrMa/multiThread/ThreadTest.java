package MrMa.multiThread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chenyuqun
 */
public class ThreadTest {
    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("", 0);
        System.out.println(reference.getReference());
        reference.set("hello", 1);
        System.out.println(reference.getReference());
        reference.set("hello", 2);
        System.out.println(reference.getReference());
        reference.compareAndSet("hello","world", 2,3);
        System.out.println(reference.getReference());
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "1");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("");
    }
}


package javabase.collection.queue;

import com.google.common.collect.Queues;
import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

/**
 * @author chenyuqun
 * @date 2021/1/13 10:31 上午
 */
public class QueueTest {
    @Test
    public void testQueue() {
        Queue<String> queue = Queues.newPriorityQueue();
        // add 与 offer
        // 区别是当 queue 没有空间的时候，add会报错，offer会返回空
        // remove 与 poll
        // 区别是当 queue 是空的时候， remove会报错, poll会返回空
        System.out.println(queue.poll());
        boolean hasError = false;
        try {
            System.out.println(queue.remove());
        } catch (Exception e) {
            hasError = true;
        }
        Assert.assertTrue(hasError);
        // peek 与 element
        // 区别是当 queue 为空的时候，element会报错，peek会返回空
        System.out.println(queue.peek());
        hasError = false;
        try {
            System.out.println(queue.element());
        } catch (Exception e) {
            hasError = true;
        }
        Assert.assertTrue(hasError);
    }
}

package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 * @date 2020/11/27 11:12 下午
 * volatile:保证线程的可见性，禁止指令重排序, volatile无法保证操作的原子性。
 */
public class VolatileTest {
    private volatile boolean isLoop = true;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.setLoop(false);
        });
        thread.start();
        System.out.println("loop begin");
        while (test.isLoop()) {
            // 不可以有下面这段代码，如果有了，主线程会知道isLoop变了，可能是下面的话会导致主线程的内存空间刷新。重新载入了isLoop的值。
            //System.out.println("I am cycling");
        }
        System.out.println("cycling end");
    }

    public boolean isLoop() {
        return isLoop;
    }

    public void setLoop(boolean loop) {
        isLoop = loop;
    }
}

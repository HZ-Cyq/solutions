package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 * @date 2020/11/27 11:58 下午
 */
public class VolatileTestStd {
    boolean running = true;
    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end!");
    }
    public static void main(String[] args) {
        VolatileTestStd t = new VolatileTestStd();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}

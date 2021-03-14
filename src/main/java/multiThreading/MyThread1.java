package multiThreading;

/**
 * @author playcrab_chenyuqun
 */
public class MyThread1 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
    }
}

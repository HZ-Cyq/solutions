package multiThreading.MrLiao;

/**
 * @author chenyuqun
 * @date 2021/1/18 3:30 下午
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1);
        myThread.interrupt();
        myThread.join();
        System.out.println("end");
    }

    static class MyThread extends Thread {
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");
            }
        }
    }
}

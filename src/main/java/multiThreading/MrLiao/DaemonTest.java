package multiThreading.MrLiao;

/**
 * @author chenyuqun
 * @date 2021/1/18 5:33 下午
 */
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread1();
//        thread.setDaemon(true);
        thread.start();
        System.out.println("main: wait 3 sec...");
        Thread.sleep(3000);
        System.out.println("main: end");
    }
}

class Thread1 extends Thread {

    public void run() {
        for (; ; ) {
            System.out.println("Thread-1: running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

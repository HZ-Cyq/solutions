package MrMa.multiThread;

/**
 * 在线程执行的时候阻塞
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello world");
        });
        thread.wait();

    }
}

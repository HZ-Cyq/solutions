package MrMa.multiThread.state;

/**
 * @author chenyuqun
 * @date 2020/12/2 11:27 下午
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("thread1 start"));

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 start");
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread3 start");
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}

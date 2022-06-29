package MrMa.multiThread.state;

/**
 * 比如有两个线程thread1和thread2，我们希望thread2在thread1之后运行，这个时候就可以用join
 *
 * @author chenyuqun
 * @date 2020/12/2 11:27 下午
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                System.out.println("thread1 " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2");
        });

        thread1.start();
        thread2.start();
    }
}

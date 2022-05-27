package MrMa.multiThread.state;

/**
 * 比如有两个线程thread1和thread2，我们希望thread2在thread1之后运行，这个时候就可以用join
 * @author chenyuqun
 * @date 2020/12/2 11:27 下午
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("thread1"));
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2");});
        thread2.start();
        thread1.start();
    }
}

package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.TimeUnit;

/**
 * volatile变量写入主存，线程中的所有变量也会写入主存。
 * 读取volatile变量，线程中的所有变量也会重新从主存中读。
 *
 * @author chenyuqun
 * @date 2020/11/28 2:37 下午
 */
public class VolatileTest2 {
    volatile boolean a = true;

    boolean b = true;

    public static void main(String[] args) {
        VolatileTest2 test = new VolatileTest2();
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.b = false;
            // 将volatile赋值写在最后，这样b的修改也会写入到主存中
            test.a = false;
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("cycle start");
            while(test.a) {

            }
            System.out.println("b become false: " + test.b);
        });

        thread1.start();
        thread2.start();
    }
}

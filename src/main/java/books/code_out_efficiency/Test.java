package books.code_out_efficiency;


import java.util.concurrent.CountDownLatch;

/**
 * @author chenyuqun
 * @date 2022/2/16 4:11 下午
 */
public class Test {

    static int THREAD_NUM = 1000;

    private int a ;

    static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) {
        Test test = new Test();
        Thread thread[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            thread[i] = new Thread(test::addA);
        }
        for (int i = 0; i < THREAD_NUM; i++) {
            thread[i].start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.getA());
    }

    public void addA() {
        a++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        countDownLatch.countDown();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void method1() {
        throw new ArithmeticException();
    }

    public void method2() {
        method1();
    }
}

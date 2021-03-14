package MrMa.multiThread.reentrant_lock;

/**
 * 可重入锁：synchronized方法可以调用synchronized方法。
 * @author chenyuqun
 * @date 2020/12/19 11:33 下午
 */
public class ReentrantLock1 {
    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        m2();
    }

    synchronized void m2() {
        System.out.println("m2");
    }

    public static void main(String[] args){
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        Thread thread1 = new Thread(reentrantLock1::m1);
        thread1.start();
        Thread thread2 = new Thread(reentrantLock1::m2);
        thread2.start();
    }
}

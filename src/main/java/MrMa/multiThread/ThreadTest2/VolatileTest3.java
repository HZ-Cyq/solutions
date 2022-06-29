package MrMa.multiThread.ThreadTest2;

import java.util.concurrent.TimeUnit;

public class VolatileTest3 {

    private int a = 0;

    public static void main(String[] args) {
        VolatileTest3 volatileTest3 = new VolatileTest3();
        volatileTest3.test();
    }

    private void test() {
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(this::addA);
            thread.start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }

    private void addA() {
        this.a++;
    }

}

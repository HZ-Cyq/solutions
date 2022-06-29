package MrMa.multiThread.reentrant_lock;

public class SynchronizedTest {

    private int a;

    private static int b;

    public synchronized void addA1() {
        a++;
    }

    public void addA2() {
        synchronized (this) {
            a++;
        }
    }

    public static synchronized void addB1() {
        b++;
    }

    public static void addB2() {
        synchronized (SynchronizedTest.class) {
            b++;
        }
    }

}

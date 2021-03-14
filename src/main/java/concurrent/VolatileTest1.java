package concurrent;

/**
 * @author chenyuqun
 * @date 2021/1/28 5:18 下午
 */
public class VolatileTest1 {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v) { // 这里x会是多少呢？ } }
            System.out.println("read x: " + x);
        }
    }

    public static void main(String[] args) {
        VolatileTest1 test1 = new VolatileTest1();
        test1.writer();
        test1.reader();
    }
}

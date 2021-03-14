package multiThreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/18 2:20 下午
 */
public class ThreadLocalTest {
    static ThreadLocal<Integer> threadLocalInt = new ThreadLocal<>();
    void processInteger(Integer i) {
        threadLocalInt.set(i);
        step1();
        step2();
    }
    void step1() {
        Integer i = threadLocalInt.get();
    }

    void step2() {

    }
}

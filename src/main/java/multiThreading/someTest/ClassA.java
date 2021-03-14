package multiThreading.someTest;

/**
 * @author chenyuqun
 * @date 2021/1/10 8:19 下午
 */
public class ClassA {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> System.out.println("helllo world"));
        thread1.getState();
    }
}

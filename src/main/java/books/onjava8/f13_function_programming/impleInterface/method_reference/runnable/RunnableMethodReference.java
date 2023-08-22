package books.onjava8.f13_function_programming.impleInterface.method_reference.runnable;

/**
 * @author chenyuqun
 * @date 2021/5/28 10:27 上午
 */
public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda")).start();

        new Thread(Go::go).start();
    }
}

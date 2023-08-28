package books.java_concurrency_in_practice.f01_introduce;


/**
 * @author chenyuqun
 * @date 2023/8/24
 */
public class f0101_UnsafeSequence {

//    @GuardedBy("this")
    private int value;

    public int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        f0101_UnsafeSequence unsafeSequence = new f0101_UnsafeSequence();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(unsafeSequence.getNext());
            });
            thread.start();
        }
    }
}

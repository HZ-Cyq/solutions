package books.code_out_efficiency.B05_02_try_catch_finally;

/**
 * @author chenyuqun
 * @date 2022/2/23 4:29 下午
 */
public class FinallyTest2 {

    public static void main(String[] args) {
        int re = finallyNotWork();
        System.out.println("re: " + re);
    }

    public static int finallyNotWork() {
        int temp = 10000;
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return ++temp;
        } finally {
            temp = 9999;
            System.out.println(temp);
        }
    }
}

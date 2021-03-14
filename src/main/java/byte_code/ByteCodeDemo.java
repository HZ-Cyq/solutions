package byte_code;

/**
 * @author chenyuqun
 * @date 2021/1/29 3:20 下午
 */
public class ByteCodeDemo {
    private int a = 1;

    public int add() {
        int b = 2;
        int c = a + b;
        System.out.println(c);
        return c;
    }
}

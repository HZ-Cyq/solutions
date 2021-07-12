package java_language_basic.tcp_socket;

/**
 * @author chenyuqun
 * @date 2020/11/13 1:52 下午
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[2];
        System.out.println(array.length);
        array[0] = 1;
        array[1] = 2;
        for (int value : array) {
            System.out.println(value);
        }

    }

}

package books.onjava8.f04_operator;

/**
 * @author chenyuqun
 * @date 2021/5/10 9:03 下午
 */
public class Literals {
    public static void main(String[] args) {
        // 最大的char, byte和short
        char c = 0xffff; // 最大 char 型16进制值
        System.out.println(
                "c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // 最大 byte 型16进制值  01111111;
        System.out.println(
                "b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // 最大 short 型16进制值
        System.out.println(
                "s: " + Integer.toBinaryString(s));

        // 当类型不明确时，必须辅以 字面值常量关联 来帮助编译器识别
        long a = 1L;

        // 下划线
        double d = 341_435_91.123_222;
        System.out.println(d);

        int i1 = 0;
        int i2 = 1;
        System.out.println(i1 ^ i2);

    }
}

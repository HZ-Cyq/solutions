package java_basic.io.encryption.code;

import java.util.Arrays;
import java.util.Base64;

/**
 * 编码原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串
 * 4（个） * 6（int） = 3（个） * 8（byte）
 * 24byte的二进制，被4个int表示，需要32byte空间，所以数据量会增加1/3.
 *
 * @author chenyuqun
 * @date 2021/4/19 1:42 下午
 */
public class Base64Coder {
    public static void main(String[] args) {
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
        String b64encode = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encode);
        byte[] output = Base64.getDecoder().decode(b64encode);
        for (byte b : output) {
            System.out.printf("%x, ", b);
        }
        System.out.println();
        base64UrlEncoder();
    }

    public static void base64UrlEncoder() {
        byte[] input = new byte[]{0x01, 0x02, 0x7f, 0x00};
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));
    }

}


package java_basic.io.encryption.code;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author chenyuqun
 * @date 2021/4/19 10:28 上午
 */
public class URLCoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode("中文!", String.valueOf(StandardCharsets.UTF_8));
        System.out.println("encoded: " + encoded);
        String decoded = URLDecoder.decode(encoded, String.valueOf(StandardCharsets.UTF_8));
        System.out.println("decoded: " + decoded);
    }
}

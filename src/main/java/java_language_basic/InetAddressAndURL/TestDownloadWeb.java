package java_language_basic.InetAddressAndURL;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author playcrab_chenyuqun
 */
public class TestDownloadWeb {

    public static void main(String[] args) throws IOException {
        String url = "http://www.baidu.com";
        InputStream in = (new URL(url)).openStream();
        int c = -1;
        // 按字节的方式输入数据和输出数据
        while((c = in.read()) != -1) {
            System.out.write(c);
        }
    }

    @Test
    public void testBigDecimal() {
        int a = 1;
        double b = a;
        double c = 1.1;
        System.out.println(b);
        System.out.println(c);
        Map<String, Integer> map = Maps.newHashMap();
        map.put("hello",1);
        Object d = map.get("hell");
        Object e = map.get("hello");
        System.out.println(d);
        System.out.println(e);
    }
}

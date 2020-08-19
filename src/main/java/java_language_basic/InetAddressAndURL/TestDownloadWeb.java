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
        String url = "http://www.fan7.cn";
        InputStream in = (new URL(url)).openStream();
        int c = -1;
        // 按字节的方式输入数据和输出数据
        while((c = in.read()) != -1) {
            System.out.write(c);
        }
    }

}

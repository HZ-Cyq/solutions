package java_language_basic.InetAddressAndURL;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author playcrab_chenyuqun
 */
public class TestUrl {
    @Test
    public void testURL() {
        String str = "http://www.xupt.edu.cn:8080/index.jsp";
        URL getURL = null;
        try {
            getURL = new URL(str);
        } catch (MalformedURLException e) {
            System.err.println("创新URL失败");
            e.printStackTrace();
        }
        System.out.println("访问协议: " + getURL.getProtocol());
        System.out.println("主机名称: " + getURL.getHost());
        System.out.println("主机端口号: " + getURL.getPort());
        System.out.println("URL文件名: " + getURL.getFile());
    }

}

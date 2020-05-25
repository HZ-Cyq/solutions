package java_language_basic.InetAddressAndURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author playcrab_chenyuqun
 */
public class TestGetByName {
    public static void main(String[] args) {
        String host = "localhost";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入网络地址：");
        try {
            host = br.readLine();
        } catch (IOException e) {
            System.err.println("输入信息失败");
            e.printStackTrace();
        }

        InetAddress inet = null;
        try {
            inet = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.err.println("获取信息失败");
            e.printStackTrace();
        }
        System.out.println("主机地址 = " + inet.getHostAddress());
        System.out.println("主机名称 = " + inet.getHostName());
        System.out.println("是否是回环地址 = " + inet.isLoopbackAddress());
    }
}

package java_language_basic.InetAddressAndURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author playcrab_chenyuqun
 */
public class TestGetAllByName {
    public static void main(String[] args) {
        String host = "localhost";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入网络地址：");
        try {
            host = br.readLine();
        } catch (IOException e) {
            System.err.println("输入信息失败");
            e.printStackTrace();
        }
        InetAddress[] addresses = new InetAddress[0];
        try {
            addresses = InetAddress.getAllByName(host);
        } catch (UnknownHostException e) {
            System.err.println("获得信息失败");
            e.printStackTrace();
        }
        for(InetAddress address : addresses) {
            System.out.println(address);
        }
    }
}

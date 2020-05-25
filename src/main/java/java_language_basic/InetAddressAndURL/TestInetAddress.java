package java_language_basic.InetAddressAndURL;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Vector;

import static java.net.NetworkInterface.getNetworkInterfaces;

/**
 * @author playcrab_chenyuqun
 */
public class TestInetAddress {
    @Test
    public void testGetLocalHost() {
        InetAddress inet = null;
        try {
            inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.err.println("获得本地信息失败" + e.toString());
        }
        System.out.println(inet);
        byte[] ip = inet.getAddress();
        for(int i = 0; i < ip.length; i++) {
            // 将byte数值转换为int数值。
            // 之所以加上256，是因为它的模是256.
            int ips = ip[i] >= 0 ? ip[i] : ip[i] + 256;
            System.out.print(ips + ".");
        }
    }

    @Test
    public void testGetNetworkInterfaces() {
        Enumeration<NetworkInterface> netInterfaces = null;
        try{
            netInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            System.err.println("获得本地信息失败"+ e.toString());
            e.printStackTrace();
        }
        while(netInterfaces.hasMoreElements()) {
            NetworkInterface ni = netInterfaces.nextElement();
            System.out.println("网卡： " + ni.getDisplayName());
            System.out.println("名称： " + ni.getInetAddresses());
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements()) {
                System.out.println("IP: " + ips.nextElement().getHostAddress());
            }
        }
    }


    public static  void testEnumeration() {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}

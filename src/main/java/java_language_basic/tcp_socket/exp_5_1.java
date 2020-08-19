package java_language_basic.tcp_socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 最基础socket中的方法
 * @author chenyuqun
 */
public class exp_5_1 {
    public static void main(String[] args) {
        String hostName = "www.xupt.edu.cn";
        int port = 80;
        Socket cs = null;
        try {
            cs = new Socket(hostName, port);
            System.out.println("连接" + hostName + "的端口" + port + "成功");
            System.out.println("对方主机" + cs.getInetAddress() + ":对方端口" + cs.getPort());
            System.out.println("本地主机" + cs.getLocalAddress() + ":本地端口" + cs.getLocalPort());
            cs.close();
        } catch (IOException e) {
            System.err.println("无法连接指定服务器");
        }
    }
}

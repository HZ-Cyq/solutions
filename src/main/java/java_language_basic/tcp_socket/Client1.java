package java_language_basic.tcp_socket;

/**
 * @author chenyuqun
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;

public class Client1 {

    private static int MAX_LENGTH = 10240;
    private static int[] array = new int[MAX_LENGTH];
    private static int length;

    public static void main(String[] args) throws IOException {

        // 将http://www.fan7.cn的请求消息存在array中
        initWebInfo();

        System.out.println(Arrays.stream(array));
        //客户端请求与本机在80端口建立TCP连接
        Socket client = new Socket("127.0.0.1", 8025);
        client.setSoTimeout(10000);

        //获取Socket的输出流，用来发送数据到服务端
        PrintStream out = new PrintStream(client.getOutputStream());
        //获取Socket的输入流，用来接收从服务端发送过来的数据
        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));

        out.println(Arrays.stream(array));

        String code = buf.readLine();
        System.out.println(code);

        if (client != null) {
            //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
            client.close(); //只关闭socket，其关联的输入输出流也会被关闭
        }
    }

    public static void initWebInfo() throws IOException {
        String url = "http://www.fan7.cn";
        InputStream in = (new URL(url)).openStream();
        int c = -1;
        // 按字节的方式输入数据和输出数据
        while ((c = in.read()) != -1) {
            System.out.write(c);
            array[length++] = c;
        }
    }

}

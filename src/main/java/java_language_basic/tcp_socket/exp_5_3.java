package java_language_basic.tcp_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * TCP客户端代码
 * @author chenyuqun
 */
public class exp_5_3 {
    public static void main(String[] args) throws IOException {
        Socket sc = null;
        DataOutputStream os = null;
        DataInputStream is = null;

        try {
            sc = new Socket("127.0.0.1",8000);
            is = new DataInputStream(sc.getInputStream());
            os = new DataOutputStream(sc.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream stdIn = new DataInputStream(System.in);
        System.out.println("请输入你的用户名：");
        String userName = stdIn.readLine();
        String fromServer, fromUser;
        while((fromServer = is.readUTF()) != null) {
            System.out.println("Server:" + fromServer);
            if(fromServer.equals("bye")) break;
            System.out.println("Client:");
            fromUser = stdIn.readLine();
            os.writeUTF(userName + "#" + fromUser);
            os.flush();
        }
        os.close();
        is.close();
        stdIn.close();
        sc.close();
    }

}

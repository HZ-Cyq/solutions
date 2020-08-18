package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author chenyuqun
 */
public class UDPServer {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            new Thread(UDPServer::run1).start();
            new Thread(UDPServer::run2).start();
        }
//        run(8806);
//        run(8807);
    }

    private static void run1() {
        run(8806);
        System.out.println("run1");
    }

    private static void run2() {
        run(8806);
        System.out.println("run2");
    }

    private static void run3() {
        run(8807);
    }

    private static void run(int port) {
        try (DatagramSocket socket = new DatagramSocket(null)) {
            socket.setReuseAddress(true);
            socket.bind(new InetSocketAddress(port));
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);
            byte[] arr = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(arr, 0, len));
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

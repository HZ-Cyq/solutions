package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import static java.lang.Thread.sleep;

/**
 * @author chenyuqun
 */
public class UDPClient {

    public static void main(String[] args) throws InterruptedException {
        send(8806);
//        sleep(1000);
        send(8806);
    }

    public static void send(int port) {
        try (DatagramSocket socket = new DatagramSocket(null)) {
            byte[] data = "Hello".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            packet.setSocketAddress(new InetSocketAddress("localhost", port));
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

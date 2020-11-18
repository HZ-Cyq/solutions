package design_pattern.structural.decorate;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenyuqun
 */
public class DecorateTest {
    String readPath = "src/main/java/design_pattern/structural/decorate/text_for_read";

    @Test
    public void testBufferedInput() throws IOException {
       InputStream in = new FileInputStream(readPath);
       // bufferedInputStream是一个支持带缓存功能的数据读取类，可以提高数据的读取效率
       InputStream bufferedIn = new BufferedInputStream(in);
       byte[] data = new byte[128];
       while(bufferedIn.read(data) != -1) {
           printByte(data);
       }
    }

    @Test
    public void testDataInputStream() throws IOException {
        FileInputStream in = new FileInputStream(readPath);
        DataInputStream dataIn = new DataInputStream(in);
        int data = dataIn.readInt();
        System.out.print(data);
    }

    @Test
    public void testDecorate() throws IOException {
        InputStream in = new FileInputStream(readPath);
        InputStream bufferedIn = new BufferedInputStream(in);
        DataInputStream dataIn = new DataInputStream(bufferedIn);
        int data = dataIn.readInt();
        System.out.print(data);
    }


    private void printByte(byte[] data) {
        for(byte byteData : data) {
            if(byteData == 0) {
                break;
            }
            System.out.print((char)byteData);
        }
    }

    private void printFile(InputStream input) {
        int data;
        try {
            while (((data = input.read()) != -1)) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

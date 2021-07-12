package java_basic.io.io2.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenyuqun
 * @date 2021/4/14 6:33 下午
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        InputStream inputStream = new FileInputStream("./src/main/java/java_basic/io/io2/stream/readFile.txt");
        int byteCode;
        while ((byteCode = inputStream.read()) != -1) {
            System.out.print((char) byteCode);
        }
    }
}

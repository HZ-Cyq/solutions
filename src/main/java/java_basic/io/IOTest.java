package java_basic.io;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author chenyuqun
 * 参考：http://tutorials.jenkov.com/java-io/index.html
 */
public class IOTest {

    String pathForRead = "src/main/java/java_basic/io/text_for_read";

    String pathForWrite = "src/main/java/java_basic/io/text_for_write";

    /******************** Stream ******************/
    @Test
    public void testInputStream() throws IOException {
        InputStream input = new FileInputStream(pathForRead);
        printFile(input);
    }

    @Test
    public void testOutputStream() throws IOException {
        OutputStream output = new FileOutputStream(pathForWrite);
        output.write("hello, world!".getBytes());
        output.close();
    }

    @Test
    public void testCombiningStream() throws FileNotFoundException {
        InputStream input = new BufferedInputStream(new FileInputStream(pathForRead));
        printFile(input);
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

    @Test
    public void testByteAndCharArrays() throws IOException {
        byte[] bytes = "hello, world!".getBytes();
        InputStream input = new ByteArrayInputStream(bytes);
        int data;
        while((data = input.read())!= -1) {
            // read byte
            input.read();
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("This text is converted to bytes".getBytes("UTF-8"));
        byte[] bytes1 = output.toByteArray();
        for(byte b : bytes1) {
            System.out.print((char)b);
        }
    }

    @Test
    public void testInOutError() throws FileNotFoundException {
        OutputStream output = new FileOutputStream(pathForWrite);
        PrintStream printOut = new PrintStream(output);
        System.setOut(printOut);
        // make out link to src/main/java/java_basic/io/text_for_write
        System.out.print("hello, out");
    }
}

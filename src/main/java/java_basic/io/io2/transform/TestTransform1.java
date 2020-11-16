package java_basic.io.io2.transform;

import java_basic.io.io2.Params;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：可以把一个字节流转换成一个字符流
 * InputStreamReader: 把InputStream转换成Reader
 * OutputStreamWrite: 把OutputStream转换成Writer
 * @author chenyuqun
 * @date 2020/11/16 10:23 上午
 */
public class TestTransform1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Params.transformFilePath);
        OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream);
        // 把字符串写入到指定文件中
        osw.write("hello world");
        osw.close();
        osw.flush();
        // 使用 getEncoding 方法获得当前系统的默认字符编码
        System.out.println("encoding: " + osw.getEncoding());

        FileOutputStream fileOutputStream1 = new FileOutputStream(Params.transformFilePath);
        OutputStreamWriter osw1 = new OutputStreamWriter(fileOutputStream1,  "ISO8859_1");
        osw1.write("hello world 1");
        osw1.flush();
        System.out.println("encoding: " + osw.getEncoding());

        FileInputStream fileInputStream = new FileInputStream(Params.transformFilePath);
        InputStreamReader isr = new InputStreamReader(fileInputStream);
        int c;
        while((c = isr.read()) != -1) {
            System.out.print((char)c);
        }
    }
}

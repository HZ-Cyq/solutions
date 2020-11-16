package java_basic.io.io2.process;

import java_basic.io.io2.Params;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2020/11/14 5:32 下午
 */
public class TestBufferStream1 {
    public static void main(String[] args) {
        String s;
        try {
            // 在节点流 FileWriter 的外面再套一层处理流 BufferedWrite
            BufferedWriter bw = new BufferedWriter(new FileWriter(Params.processFilePath));
            for (int i = 0; i < 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                // 使用newLine方法使得每写入一个随机数就换行显示
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // 在节点流 FileReader 的外面再套用一层处理流 BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(Params.processFilePath));
            // 使用 BufferedReader 处理流里面提供 String readLine() 方法读取文件中的数据是一行一行读取的
            // 循环结束的条件就是使用 readLine() 方法读取数据返回的字符串为空值
            while( (s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

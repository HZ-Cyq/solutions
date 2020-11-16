package java_basic.io.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2020/11/14 2:13 下午
 */
public class ReadFileWithReader {
    public static void main(String[] args) {
        int ch;
        try {
            FileReader reader = new FileReader(Params.filePath);
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("系统错误：" + e.getMessage());
            System.out.println("错误：读档失败");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("错误：读档失败");
            e.printStackTrace();
        }
    }
}

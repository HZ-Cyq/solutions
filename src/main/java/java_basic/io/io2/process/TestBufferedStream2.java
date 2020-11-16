package java_basic.io.io2.process;

import java_basic.io.io2.Params;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2020/11/14 5:47 下午
 */
public class TestBufferedStream2 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Params.processFilePath));
            int c;
            // 读取第一个与第二个字节
            System.out.print((char) bis.read());
            System.out.print((char) bis.read());
            System.out.print("\n---------第三个字节开始，往后读18个字节--------------\n");
            // 在字节3处作标记，同时设置 readLimit 参数为 20
            bis.mark(20);
            for (int i = 0; i < 18 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            System.out.print("\n----------重置到原来的位置，第三字节开始，往后读18个字节-------------\n");
            // 重新回到标记的地方
            bis.reset();
            for (int i = 0; i < 18 && (c = bis.read()) != -1; i++) {
                System.out.print((char) c);
            }
            // 不可以再次重置，再次重置是不好使的
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

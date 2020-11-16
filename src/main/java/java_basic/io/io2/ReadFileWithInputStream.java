package java_basic.io.io2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2020/11/14 1:38 下午
 */
public class ReadFileWithInputStream {
    public static void main(String[] args) {
        int len;
        byte[] data = new byte[1];
        try(FileInputStream fis = new FileInputStream(Params.filePath)) {
            len = fis.available();
            System.out.println(Params.filePath + "档案大小：" + len + " bytes");
            System.out.println(Params.filePath + "档案内容如下：");
            while(fis.read(data) != -1) {
                System.out.print((char)data[0]);
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("系统错误：" + ignored.getMessage());
            System.out.println("错误：档案不存在");
        } catch (IOException e) {
            System.out.println("错误：读档失败");
            e.printStackTrace();
        }
    }
}

package java_basic.io.io2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author chenyuqun
 * @date 2020/11/13 2:52 下午
 */
public class WriteFileWithOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos;
        String data = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入存档的内容：");
        data = sc.nextLine();
        data += "\n";
        // 第二个参数设置为{@code true}代表输出流数据是在原文件中append。没有参数或者为{@code false}代表覆盖原文件。
        fos = new FileOutputStream(Params.filePath,true);
        if (data.length() != 0) {
            fos.write(data.getBytes());
            System.out.println("内容已写入a1.tx");
        } else {
            System.out.println("没有内容。无法写入");
        }
        fos.close();
    }
}

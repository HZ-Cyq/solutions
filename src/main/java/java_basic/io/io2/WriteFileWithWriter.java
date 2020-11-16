package java_basic.io.io2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author chenyuqun
 * @date 2020/11/14 1:58 下午
 */
public class WriteFileWithWriter {

    public static void main(String[] args) {
        String data;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入存档内容：");
        data = sc.nextLine();
        data += "\n";
        //TODO  这样写需要flush，数据才会被写进文件中，但是如果将writer写在括号里，就不用flush, why?
        try /*(FileWriter writer = new FileWriter(Params.filePath, true)*/{
            FileWriter writer = new FileWriter(Params.filePath, true);
            writer.write(data);
            writer.flush();
            System.out.println("内容已存入" + Params.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

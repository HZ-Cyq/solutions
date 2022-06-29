package java_basic.io.io2.file;

import java.io.File;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2021/4/13 9:29 上午
 */
public class FilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("..");
        // 构造方法传入的路径
        System.out.println(file.getPath());
        // 绝对路径
        System.out.println(file.getAbsolutePath());
        // 规范化路径
        System.out.println(file.getCanonicalPath());
        System.out.println();

        File file2 = new File("../chenyuqun");
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getCanonicalPath());

    }
}

package java_basic.io.io2.file;

import java.io.File;

/**
 * @author chenyuqun
 * @date 2021/4/13 9:33 上午
 */
public class FileSeparator {
    public static void main(String[] args) {
        // 多个路径的分隔符
        System.out.println(File.pathSeparator);
        // 路径中的分隔符
        System.out.println(File.separator);
    }
}

package java_basic.io.io2.file;

import java.io.File;

/**
 * @author chenyuqun
 * @date 2021/4/13 10:50 上午
 */
public class FileList {
    public static void main(String[] args) {
        File file = new File("./src/main/java/java_basic/io");
        printFile(file);
    }

    public static void printFile(File file) {
        if (file.isFile()) {
            System.out.println("    " + file.getPath());
            return;
        }
        if (!file.isDirectory()) {
            throw new RuntimeException("文件既不是file,又不是directory: filePath: " + file.getPath());
        }
        System.out.println(file.getPath());
        File[] files = file.listFiles();
        assert files != null;
        for (File fileInDirectory : files) {
            printFile(fileInDirectory);
        }
    }
}

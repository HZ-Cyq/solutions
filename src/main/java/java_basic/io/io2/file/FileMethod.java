package java_basic.io.io2.file;

import java.io.File;
import java.io.IOException;

/**
 * @author chenyuqun
 * @date 2021/4/13 10:08 上午
 */
public class FileMethod {

    public static void main(String[] args) throws IOException {
        checkMethod();
        createMethod();
    }

    public static void checkMethod() {
        File file = new File(".");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
    }

    public static void createMethod() throws IOException {
        File file = new File("./src/main/java/java_basic/io/io2/createNewFile.txt");
        if (file.createNewFile()) {
            System.out.println("create file success");
        }

        if (file.delete()) {
            System.out.println("delete file success");
        }
        System.out.println(file.getCanonicalPath());

        File file2 = File.createTempFile("cyq-temp-", ".txt");
        file2.deleteOnExit();
        System.out.println(file2.getCanonicalPath());
    }
}

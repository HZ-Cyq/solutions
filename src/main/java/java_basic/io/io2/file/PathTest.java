package java_basic.io.io2.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chenyuqun
 * @date 2021/4/13 11:27 上午
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get(".","src","main","java","java_basic","io");
        System.out.println(path);
        // 转换为绝对路径
        System.out.println(path.toAbsolutePath());
        // 转换为规范路径
        System.out.println(path.normalize());
        // 转换为File对象
        System.out.println(path.toFile().getName());

        // 直接遍历path
        System.out.println("path: ");
        for (Path path1 : Paths.get(".").toAbsolutePath()) {
            System.out.println(path1);
        }
    }
}

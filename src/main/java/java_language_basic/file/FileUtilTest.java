package java_language_basic.file;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 测试文件拷贝
 * https://blog.csdn.net/hardwin/article/details/7914610
 */
public class FileUtilTest {

    @Test
    public void testCopyDirectory() {
        String projectRootPath = System.getProperty("user.dir");
        System.out.println(projectRootPath);
        String separator = File.separator;
        String javaRootPath = String.join(separator, "src", "main", "java");
        String srcPath = String.join(separator, javaRootPath, "java_language_basic", "file", "test1");
        String descPath = String.join(separator, javaRootPath, "java_language_basic", "file", "test2");
        FileUtil.copy(srcPath, descPath, true);
    }

    @Test
    public void testListFileName() {
        String projectRootPath = System.getProperty("user.dir");
        String config_checker_path = String.join(File.separator, projectRootPath, "config_checker");
        List<String> strings = FileUtil.listFileNames(config_checker_path);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testLoopFile() throws IOException {
        String projectRootPath = System.getProperty("user.dir");
        String config_checker_path = String.join(File.separator, projectRootPath, "config_checker");
        for (File file : FileUtil.loopFiles(config_checker_path)) {
            System.out.println(file.getPath());
        }
    }
}

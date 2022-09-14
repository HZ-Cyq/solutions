package java_language_basic.file;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

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
        String javaRootPath = projectRootPath + separator + "src" + separator + "main" + separator + "java";
        String srcPath = javaRootPath + separator + "java_language_basic" + separator + "input_and_output" + separator + "test";
        String descPath = javaRootPath + separator + "java_language_basic" + separator + "file";
        FileUtil.copy(srcPath, descPath, true);
    }
}

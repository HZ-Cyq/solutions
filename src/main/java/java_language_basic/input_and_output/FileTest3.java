package java_language_basic.input_and_output;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author playcrab_chenyuqun
 */
public class FileTest3 {

    /**
     * 测试File类
     */
    @Test
    public void testFile() {
        /**
         * 1、获得文件
         */
        String args = "src/main/java/java_language_basic/input_and_output/test";
        String javaPath = System.getProperty("user.dir");
        // 拼接上就可以得到文件的全路径
        String filePath = javaPath + "/" + args;
        File myFile = new File(filePath);

        /**
         * 2、打印文件的一些信息
         */
        println(filePath);
        println(myFile.getName() + "是目录？" + myFile.isDirectory());
        println("可读/写？" + myFile.canRead() + "/" + myFile.canWrite());
        // :set invlist 可以显示文件的不可见字符,在ideal中不好使，可以用原装的vi
        println("文件字节长度: " + myFile.length());
        println("getPath: " + myFile.getPath());
        println("getAbsolutePath: " + myFile.getAbsolutePath());
        println("getParentPath: " + myFile.getParent());
        println("lastModified: " + myFile.lastModified());

        /**
         * 3、修改文件名(不好使)
         */
//        File newFile = new File("testNew");
//        myFile.renameTo(newFile);

        /**
         * 4、打印文件所在目录的一些信息
         */
        File directory = new File(myFile.getParent());
        String[] files = directory.list();
        println("all the file in the same directory: ");
        for(int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 测试RandomAccessFile
     */
    @Test
    public void testRandomAccessFile() throws IOException {
        String args = "src/main/java/java_language_basic/input_and_output/random_test";
        String javaPath = System.getProperty("user.dir");
        String filePath = javaPath + "/" + args;
        RandomAccessFile randomFile = new RandomAccessFile(filePath,"rw");
        randomFile.writeBoolean(true);
        randomFile.writeInt(1);
        randomFile.writeChar('a');
        randomFile.writeDouble(123.456);
        randomFile.writeUTF("hello");

        randomFile.seek(1);
        System.out.println(randomFile.readInt());
        System.out.println(randomFile.readChar());
        System.out.println(randomFile.readDouble());

        randomFile.seek(0);
        System.out.println(randomFile.readBoolean());
        randomFile.close();
    }

    /**
     * 打印
     * @param x
     */
    private void println(String x) {
        System.out.println(x);
    }


}

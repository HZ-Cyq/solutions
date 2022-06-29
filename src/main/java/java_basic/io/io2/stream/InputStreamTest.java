package java_basic.io.io2.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyuqun
 * @date 2021/4/14 6:33 下午
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        InputStream inputStream = new FileInputStream("./src/main/java/java_basic/io/io2/stream/readFile.txt");
        int byteCode;
        while ((byteCode = inputStream.read()) != -1) {
            System.out.print((char) byteCode);
        }
    }

    @Test
    public void test() {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> a = list.stream().filter(ele -> !ele.equals("a")).collect(Collectors.toList());
        for (String s : a) {
            System.out.println(s);
        }
    }

}

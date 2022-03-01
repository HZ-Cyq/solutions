package books.code_out_efficiency.B06_collection_test;

import com.google.common.collect.Lists;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2022/2/28 10:14 上午
 */
public class SomeTest {
    public static void main(String[] args) throws IOException {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        String[] array = new String[10];
//        for (int i = 0; i < 10; i++) {
//            array[i] = "hello";
//        }
//        list.toArray(array);
//        System.out.println(Arrays.asList(array));
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        OutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(list);

    }
}

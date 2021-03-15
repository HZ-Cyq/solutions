package books.jvm.jvm_1_outofmemory;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * VM Args: -Xms20m Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author chenyuqun
 * @date 2021/3/14 10:17 下午
 */
public class HeapOMM {

    static class OMMObject {

    }

    public HeapOMM() {
    }

    public static void main(String[] args) {
        List<OMMObject> lists = Lists.newArrayList();
        while (true) {
            lists.add(new OMMObject());
        }
    }

}

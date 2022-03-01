package books.code_out_efficiency.B04_01_method_instructions;

import org.junit.Assert;

import java.util.HashMap;

/**
 * @author chenyuqun
 * @date 2022/2/24 3:05 下午
 */
public class MethodInstruction {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(10);
        hashMap.put("1","1");
        System.out.println(hashMap);

        String[] array = {"a", "b"};
        Object obj = array;
        ((String[]) obj)[0] = "object";
        Assert.assertEquals("object", array[0]);
    }

    public void methodWithLambda() {
        Thread thread = new Thread(() -> System.out.println("hello world"));
    }
}

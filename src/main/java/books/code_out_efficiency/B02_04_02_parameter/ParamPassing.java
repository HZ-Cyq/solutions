package books.code_out_efficiency.B02_04_02_parameter;

import org.junit.Assert;

/**
 * @author chenyuqun
 * @date 2022/1/20 4:57 下午
 */
public class ParamPassing {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        method(stringBuilder);
        System.out.println(stringBuilder.toString());
        Assert.assertEquals("hello world", stringBuilder.toString());
    }

    public static void method(StringBuilder stringBuilder) {
        stringBuilder.append("hello world");
        stringBuilder = new StringBuilder();
        stringBuilder.append("hello java");
    }

}

package onjava8.f19_type_info.pre.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenyuqun
 * @date 2021/5/20 8:58 下午
 */
public class RegularExpTest {

    public static void main(String[] args) {
        testReplaceFirst();
        testReplaceAll();
    }

    /**
     * 替换符合正则的所有文字
     */
    public static void testReplaceAll() {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World, 正则表达式 Hello World");
        System.out.println(matcher.replaceAll("Java"));
        // 输出:
        // Java Hello World, Java Hello World
    }

    /**
     * 替换符合正则的第一个文字
     */
    public static void testReplaceFirst() {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World, 正则表达式 Hello World");
        System.out.println(matcher.replaceFirst("Java"));
        // 输出
        // Java Hello World, 正则表达式 Hello World
    }
}

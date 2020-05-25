package javabase.stringTest;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class StringTest {
    @Test
    public void test1() {
        String str = "1_2_3";
        String[] strs = str.split("_");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}

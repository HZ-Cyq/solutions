package javabase.init;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class initTest {
    @Test
    public void testAttribute() {
       InitAttributeTest initAttributeTest = new InitAttributeTest();
       System.out.println(initAttributeTest.getBooleanValue());
       System.out.println(initAttributeTest.isBooleanValue());
       System.out.println(initAttributeTest.getAnInt());
       System.out.println(initAttributeTest.getAnLong());
       System.out.println(initAttributeTest.getStr());
    }
}

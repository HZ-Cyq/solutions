package javabase.inherit;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class TestInherit {
    @Test
    public void testAttribute() {
        Son son = new Son(2);
        son.printA();
    }
    @Test
    public void testCast() {
        Father father = new Son(2);
        Son son = (Son) father;
        son.printA();
    }
}

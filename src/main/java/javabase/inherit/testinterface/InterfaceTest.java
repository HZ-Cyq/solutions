package javabase.inherit.testinterface;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class InterfaceTest {
    @Test
    public void testInterface() {
        Interface implementOne = new ImplementOne();
        implementOne.printHello();

        Interface implementTwo = new ImplementTwo();
        implementTwo.printHello();
    }
}

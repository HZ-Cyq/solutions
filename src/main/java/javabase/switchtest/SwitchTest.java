package javabase.switchtest;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class SwitchTest {
    @Test
    public void testSwitch() {
        int a = 1;
        switch (a) {
            case 1: System.out.println("case 1"); break;
            case 2: System.out.println("case 2"); break;
            case 3: System.out.println("case 3"); break;
        }
    }
}

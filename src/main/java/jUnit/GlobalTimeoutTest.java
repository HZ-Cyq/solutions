package jUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun
 */
public class GlobalTimeoutTest {

    @Rule
    public TestRule globalTimeout = new Timeout(20L, TimeUnit.SECONDS);

    @Test
    public void infiniteLoop1() {
        while (true) {

        }
    }

    @Test
    public void infiniteLoop2() {
        while (true) {

        }
    }

}

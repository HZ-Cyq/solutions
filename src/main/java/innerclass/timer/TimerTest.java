package innerclass.timer;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class TimerTest {
    @Test
    public void testTimer() {
        TimeExecute timeExecute = new TimeExecute();
        timeExecute.reset((r)->{System.out.println("hello world: " + r);});
    }
}

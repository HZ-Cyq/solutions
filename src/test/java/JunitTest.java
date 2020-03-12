import org.junit.Assert;
import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class JunitTest {
    @Test
    public void test1() {
        int a = 2;
        int b = 3;
        Assert.assertEquals(a, b);
    }
}

package key.final_and_static;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class FinalAndStaticTest {
    @Test
    public void testObject() {
        MyObject myObject = new MyObject();
        Object object = ((Object) myObject);
        System.out.println(object.getClass());
    }
}

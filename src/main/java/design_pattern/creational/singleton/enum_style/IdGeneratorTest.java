package design_pattern.creational.singleton.enum_style;

import org.junit.Test;

/**
 * @author chenyuqun
 */
public class IdGeneratorTest {
    @Test
    public void testIdGenerator() {
        IdGenerator.INSTANCE.getId();
    }
}

package javabase.precondtions;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class PreconditionsTest {

    @Test
    public void testCheckArgument() {
        boolean argument = true;
        Preconditions.checkArgument(!argument, "hello %s %s!","world", "world");
    }

}

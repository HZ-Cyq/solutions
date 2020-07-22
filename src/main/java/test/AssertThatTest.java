package test;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static test.IsNotANumber.notANumber;

/**
 * https://juejin.im/entry/583d2b51ac502e006c290f38
 *
 * @author chenyuqun
 */
public class AssertThatTest {
    @Test
    public void testAssert() {
        String str = "hello";
        // equalTo
        Assert.assertThat(str, equalTo("hello"));
        int a = 16;
        Assert.assertThat(a, equalTo(16));
        // is
        Assert.assertThat(str, is("hello"));
        Assert.assertThat(a, is(16));
        // 自定义匹配器
        Assert.assertThat(sqrt(-1), is(notANumber()));
    }
}

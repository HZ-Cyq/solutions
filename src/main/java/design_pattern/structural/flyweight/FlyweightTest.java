package design_pattern.structural.flyweight;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class FlyweightTest {

    /**
     * Integer就用了享元模式，IntegerCache就是一个创建Integer的工厂。
     */
    @Test
    public void testInteger() {
        // 执行了自动装箱 Integer i = Integer.valueOf(56);
        Integer i1 = 56;
        Integer i2 = Integer.valueOf(56);
        Integer i3 = 128;
        Integer i4 = 128;
        Assert.assertTrue(i1 == i2);
        // 如果没有设置-Djava.lang.Integer.IntegerCache.high="255",i3!=i4。因为默认的Integer享元工厂值存[-128,127]之间的数
        Assert.assertTrue(i3 != i4);
    }

    @Test
    public void testString() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        Assert.assertTrue(str1 == str2);
        Assert.assertTrue(str1 != str3);
    }
}

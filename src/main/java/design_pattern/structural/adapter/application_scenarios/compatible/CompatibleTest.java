package design_pattern.structural.adapter.application_scenarios.compatible;

import org.junit.Test;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author chenyuqun
 */
public class CompatibleTest {
    // 在版本升级的时候，对于一些要废弃的接口，不直接删除，而是暂时保留，并且标注为deprecated，将内部实现逻辑委托为新的接口实现
    // JDK1.0中包含一个遍历集合容器的类Enumeration,JDK2.0对这个类重构，将它改名为Iterator。
    public static Enumeration enumeration(final Collection c) {
        return new Enumeration() {
            Iterator i = c.iterator();
            @Override
            public boolean hasMoreElements() {
                return i.hasNext();
            }

            @Override
            public Object nextElement() {
                return i.next();
            }
        };
    }
}

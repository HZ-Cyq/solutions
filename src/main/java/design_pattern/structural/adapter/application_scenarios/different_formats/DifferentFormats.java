package design_pattern.structural.adapter.application_scenarios.different_formats;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenyuqun
 */
public class DifferentFormats {
    @Test
    public void testAsList() {
        // Arrays.asList可以看做一种数据适配器，将数组类型数据转化为集合容器类型
        List<String> stooges = Arrays.asList("Larry", "moe", "Curly");

    }
}

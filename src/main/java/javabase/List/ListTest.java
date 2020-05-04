package javabase.List;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class ListTest {
    @Test
    public void testIndexOf() {
        List<String> list = Lists.newArrayList();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("0");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.indexOf("7"));
    }
}

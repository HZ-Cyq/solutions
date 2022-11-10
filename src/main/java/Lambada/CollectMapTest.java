package Lambada;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

public class CollectMapTest {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        HashMap<String, String> map = new HashMap<>();
        list.forEach(ele -> map.put(ele, ele));
    }
}

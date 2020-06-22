package javabase.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        System.out.println("index of 0: " + list.indexOf("0"));
        System.out.println("index of 1: " + list.indexOf("1"));
        System.out.println("index of 7: " + list.indexOf("7"));
        System.out.println("last element: " + list.get(list.size() - 1));
    }

    @Test
    public void testFor() {
        List<String> list = null;
        for(String value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void testLong() {
        long a = 100000000;
        long b = a * 10000000;
        System.out.println(b);
    }

    @Test
    public void shuffle() {
        List<String> list1 = Lists.newArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List<String> list2 = new ArrayList<>(list1);
        Collections.shuffle(list2);
        Collections.shuffle(list2);

        System.out.println("list1:");
        list1.forEach(v -> System.out.println(v));
        System.out.println("list2:");
        list2.forEach(v -> System.out.println(v));
    }

    @Test
    public void isEmpty() {
        List<String> list = Lists.newArrayList();
        System.out.println(list.isEmpty());
        String str1 = "hello";
        String str2 = "world";
        list.add(str1);
        System.out.println(list.isEmpty());
        list.add(str2);
        System.out.println(list.isEmpty());
        list.remove(str1);
        list.remove(str2);
        System.out.println(list.isEmpty());
    }

    @Test
    public void testGet() {
        List<JSONObject> list = Lists.newArrayList(new JSONObject(), new JSONObject());

        JSONObject json1 = new JSONObject();
        json1.put("0","0");
        list.add(json1);

        // 这里的old是值，不是引用
        JSONObject old = list.get(0);
        old = new JSONObject();

        System.out.println(old);
        System.out.println(list);
    }
}

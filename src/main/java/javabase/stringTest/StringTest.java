package javabase.stringTest;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author playcrab_chenyuqun
 */
public class StringTest {
    @Test
    public void testSplit1() {
        String str = "1_2_3";
        String[] strs = str.split("_");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    @Test
    public void testSplit2() {
        String str = "1";
        String[] strs = str.split("_");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    @Test
    public void testStringFormat() {
        String re = String.format("%s_%s","hello",1);
        System.out.println(re);
    }

    @Test
    public void test2() {
        String startTime = "2200";
        startTime = startTime.substring(0, 2) + ":" + startTime.substring(2, 4) + ":00";
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1591708232299L),
                ZoneId.systemDefault());
        long beginTime = LocalDateTime.of(dateTime.toLocalDate(), LocalTime.parse(startTime))
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(beginTime);
    }

    @Test
    public void testIsEmpty() {
        String str = "";
        Strings.isNullOrEmpty(str);
    }

    @Test
    public void testVariablePara() {
        test("name=%s&memo=%s", "Java技术栈");
    }

    private void test(String text, Object... params) {
        String result = String.format(text, params, "666");
        System.out.println(result);
    }

    @Test
    public void testSplit() {
        String str = "-1_1_2";
        String[] strs = str.split("_");
        for (String s : strs) {
            int i = Integer.parseInt(s);
            System.out.println(i);
        }
    }

    @Test
    public void testJoin() {
        System.out.println(String.join(File.separator, "hello", "world"));
    }

    @Test
    public void testFormat() {
        String desc = "hello, {}";
        String str = String.format(desc, "world");
        System.out.println(str);
    }

    @Test
    public void testSum() {
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    @Test
    public void testCatch() {
        int a = 0;
        int b = 10;
        try {
            b = 10 / a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }

    @Test
    public void testSwitch() {
        System.out.println(switchFirstChar("hello"));
    }

    private String switchFirstChar(String string) {
        char firstChar = string.charAt(0);
        String re = string;
        if(firstChar >= 'a' && firstChar <= 'z') {
            char replace = (char) (firstChar - 32);
            re = replace + string.substring(1);
        }
        return re;
    }

    @Test
    public void testStartWithNumber() {
        System.out.println(startWithNumber("123:{ID:Hero}"));
        System.out.println(startWithNumber("aaa"));
        System.out.println(startWithNumber("43"));
        System.out.println(startWithNumber("042:"));
    }

    public boolean startWithNumber(String string) {
        return Pattern.matches("^\\d+.*", string);
    }
}

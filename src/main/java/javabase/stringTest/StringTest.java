package javabase.stringTest;

import com.google.common.base.Strings;
import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @author playcrab_chenyuqun
 */
public class StringTest {
    @Test
    public void test1() {
        String str = "1_2_3";
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
    public void testFormat() {
        String desc = "hello, {}";
        String str = StringFormatter.format(desc, "world").get();
        System.out.println(str);
    }
}

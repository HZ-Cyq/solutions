package exception.log;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogbackDemo {
    public static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.info("日志测试");
        logger.error("日志测试22");
        logger.info("{}", "dw");
        String str = "hello, {what is your name},{},{}";
        Object[] argArray = new Object[2];
        argArray[0] = "hello$hi";
        argArray[0] = Matcher.quoteReplacement(String.valueOf(argArray[0]));
        argArray[1] = 2;
        for (Object s : argArray) {
            String target = "{}";
            str = Pattern.compile(target, Pattern.LITERAL).matcher(
                    str).replaceFirst(String.valueOf(s));
        }
        System.out.println(str);
    }

    @Test
    public void test2() {
    }
}

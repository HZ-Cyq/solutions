package exception.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4jDemo {
    // 在pom.xml中引入了三个文件（log4j），还添加了log4j2.xml文件，就可以让log4j接管CommonLog,不用修改代码
    public static void main(String[] args) {
        Log log = LogFactory.getLog(Log4jDemo.class);
        log.trace("hello world");
        log.debug("hello world");
        log.info("hello world");
        log.warn("hello world");
        log.error("hello world");
        log.fatal("hello world");
    }
}

package exception.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonLogDemo {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonLogDemo.class);
        log.trace("hello world");
        log.debug("hello world");
        log.info("hello world");
        log.warn("hello world");
        log.error("hello world");
        log.fatal("hello world");
    }
}

package exception.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    public static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
    public static void main(String[] args) {
        logger.info("hello {}", "hi");
    }
}

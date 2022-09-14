package exception.log;

import java.util.logging.Logger;

public class JDKLogDemo {
    public static void main(String[] args) {
        Logger global = Logger.getGlobal();
        global.info("hello world");
        global.warning("hello world");
        global.fine("fine world");
        global.severe("hello world");
    }
}

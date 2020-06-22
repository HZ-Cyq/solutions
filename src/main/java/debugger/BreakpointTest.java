package debugger;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class BreakpointTest {
    private static class BreakpointTestThread extends Thread {
        @Override
        public void run() {
            System.out.println("Set breakpoint here");
        }
    }

    public static void main(String[] args) {
        List<Thread> workers = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            workers.add(new BreakpointTestThread());
        }
        for (Thread worker : workers) {
            worker.start();
        }
        try {
            Thread.sleep(600000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

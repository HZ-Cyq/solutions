package design_pattern.behavioral.template.callBack;

/**
 * Runtime.getRuntime().addShutdownHook(new ShutdownHook())会在ApplicationShutdownHooks添加hook.
 * 在程序运行完成后,DestroyJavaVM会运行ShutDown.shutdown方法，这个方法会运行ApplicationShutdownHooks里的hooks.
 * @author playcrab_chenyuqun
 */
public class ShutdownHookDemo {
    /**
     * ApplicationShutdownHooks的runHooks里hook.join执行这个方法
     */
    private static class ShutdownHook extends Thread {
        public void run() {
            System.out.println("I am called during shutting down.");
        }
    }

    /**
     * 在ApplicationShutdownHooks的static的runHooks里打断点
     * @param args
     */
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}


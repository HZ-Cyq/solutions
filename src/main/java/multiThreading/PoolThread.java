package multithreading;

/**
 * @author playcrab_chenyuqun
 */
public class PoolThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行......");
    }
}

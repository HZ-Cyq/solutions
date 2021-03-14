package multiThreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/12 3:42 下午
 */
public class ParallelGroupMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        // 比如totalRows是25， numThreads是4
        // 第一个线程算[0,6)行的值
        // 第二个线程算[6,12)行的值
        // 第三个线程算[12, 18)行的值
        // 第四个线程算[18, 25)行的值
        int totalRows = matrix1.length;
        int numThreads = Runtime.getRuntime().availableProcessors();
        int start, end, step;
        step = totalRows / numThreads;
        start = 0;
        end = step;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            GroupMultiplierTask task = new GroupMultiplierTask(result, matrix1, matrix2, start, end);
            Thread thread = new Thread(task);
            thread.start();
            threads[i] = thread;
            start = end;
            // 倒数第一个线程的end值是totalRows, 倒数第一个值的end值是在倒数第二个线程里算的.
            end = i == (numThreads - 2) ? totalRows : end + step;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

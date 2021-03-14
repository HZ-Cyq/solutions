package multiThreading.master.ch02.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/1/12 11:46 上午
 */
public class ParallelIndividualMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int totalRows = matrix1.length;
        int totalColumns = matrix2[0].length;
        List<Thread> threads = new ArrayList<>();
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, row, column);
                Thread thread = new Thread(task);
                thread.start();
                threads.add(thread);
                if (threads.size() % 10 == 0) {
                    waitForThreads(threads);
                }
            }
        }
    }

    /**
     * 等待threads数组里所有的线程结束之后再执行。
     *
     * @param threads
     */
    public static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}

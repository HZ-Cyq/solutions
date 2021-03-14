package multiThreading.master.ch02.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/1/12 2:21 下午
 */
public class ParallelRowMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int totalRows = matrix1.length;
        List<Thread> threads = new ArrayList<>();
        for (int row = 0; row < totalRows; row++) {
            RowMultiplierTask task = new RowMultiplierTask(matrix1, matrix2, result, row);
            Thread thread = new Thread(task);
            thread.start();

            threads.add(thread);
            if (threads.size() % 10 == 0) {
                ParallelIndividualMultiplier.waitForThreads(threads);
            }
        }
    }
}

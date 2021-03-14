package multithreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/12 11:46 上午
 */
public class ParallelRowMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int totalRows = matrix1.length;
        int totalColumns = matrix2[0].length;
        Thread[] threads = new Thread[10];
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                for (int i = 0; i < 10; i++) {
                    IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, row, column);
                    threads[i] = new Thread(task);
                    threads[i].start();
                }
                join(threads);
            }
        }
    }

    /**
     * 等待threads数组里所有的线程结束之后再执行。
     *
     * @param threads
     */
    public static void join(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

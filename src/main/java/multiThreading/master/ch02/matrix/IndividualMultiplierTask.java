package multiThreading.master.ch02.matrix;

/**
 * 每个元素一个线程
 *
 * @author chenyuqun
 * @date 2021/1/12 10:42 上午
 */
public class IndividualMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private int row;
    private int column;

    public IndividualMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int row, int column) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
        this.column = column;
    }

    @Override
    public void run() {
        int totalColumns = matrix1[0].length;
        int re = 0;
        for (int i = 0; i < totalColumns; i++) {
            re += matrix1[row][i] * matrix2[i][column];
        }
        result[row][column] = re;
    }
}

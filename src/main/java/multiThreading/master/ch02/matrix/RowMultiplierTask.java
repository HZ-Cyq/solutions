package multiThreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/12 2:10 下午
 */
public class RowMultiplierTask implements Runnable {
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final double[][] result;

    private int row;

    public RowMultiplierTask(double[][] matrix1, double[][] matrix2, double[][] result, int row) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        int totalColumns = matrix1[0].length;
        for (int i = 0; i < totalColumns; i++) {
            //result[row][i]的值
            int row_i_val = 0;
            for (int j = 0; j < totalColumns; j++) {
                row_i_val += matrix1[row][j] * matrix2[j][i];
            }
            result[row][i] = row_i_val;
        }
    }
}

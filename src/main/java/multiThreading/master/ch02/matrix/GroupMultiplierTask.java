package multiThreading.master.ch02.matrix;

/**
 * 从start行到第end行
 *
 * @author chenyuqun
 * @date 2021/1/12 2:33 下午
 */
public class GroupMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private int startIndex;
    private int endIndex;

    public GroupMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int startIndex, int endIndex) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    /**
     * 计算 [start, end) 行的值
     */
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}

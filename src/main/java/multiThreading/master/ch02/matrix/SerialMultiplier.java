package multiThreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/12 5:03 下午
 */
public class SerialMultiplier {
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int totalRows = matrix1.length;
        int totalColumns = matrix2[0].length;
        int n = matrix1[0].length;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                double re = 0;
                for (int k = 0; k < n; k++) {
                    re += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = re;
            }
        }
    }
}

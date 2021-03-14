package multiThreading.master.ch02.matrix;

/**
 * @author chenyuqun
 * @date 2021/1/12 11:34 上午
 */
public class SerialMain {
    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(100,110);
        double[][] matrix2 = MatrixGenerator.generate(110, 120);
        double[][] result = new double[100][120];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 120; j++) {
                int re = 0;
                for (int k = 0; k < 110; k++) {
                    re += matrix1[i][k] + matrix2[k][j];
                }
                result[i][j] = re;
            }
        }
    }
}

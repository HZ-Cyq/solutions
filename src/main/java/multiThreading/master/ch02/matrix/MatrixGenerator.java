package multiThreading.master.ch02.matrix;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Random;

/**
 * @author chenyuqun
 * @date 2021/1/12 10:37 上午
 */
public class MatrixGenerator {
    public static Map<Integer, double[][]> map = Maps.newHashMap();

    static {
        map.put(3, generate(3, 3));
        map.put(5, generate(5, 5));
        map.put(20, generate(20, 20));
        map.put(50, generate(50, 50));
        map.put(500, generate(500, 500));
        map.put(1000, generate(1000, 1000));
        map.put(2000, generate(2000, 2000));
    }

    public static double[][] generate(int rows, int columns) {
        double[][] result = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = random.nextDouble() * 10;
            }
        }
        return result;
    }

    public static double[][] getFixedMatrix1() {
        double[][] matrix = new double[5][5];
        matrix[0][0] = 8;
        matrix[0][1] = 6;
        matrix[0][2] = 2;
        matrix[0][3] = 1;
        matrix[0][4] = 2;

        matrix[1][0] = 6;
        matrix[1][1] = 1;
        matrix[1][2] = 3;
        matrix[1][3] = 3;
        matrix[1][4] = 4;


        matrix[2][0] = 0;
        matrix[2][1] = 4;
        matrix[2][2] = 4;
        matrix[2][3] = 5;
        matrix[2][4] = 6;

        matrix[3][0] = 0;
        matrix[3][1] = 4;
        matrix[3][2] = 4;
        matrix[3][3] = 5;
        matrix[3][4] = 6;

        matrix[4][0] = 0;
        matrix[4][1] = 4;
        matrix[4][2] = 4;
        matrix[4][3] = 5;
        matrix[4][4] = 6;
        return matrix;
    }

    public static double[][] getFixedMatrix2() {
        double[][] matrix = new double[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 7;
        matrix[0][2] = 3;
        matrix[0][3] = 6;
        matrix[0][4] = 5;

        matrix[1][0] = 2;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 4;
        matrix[1][4] = 3;


        matrix[2][0] = 3;
        matrix[2][1] = 8;
        matrix[2][2] = 3;
        matrix[2][3] = 2;
        matrix[2][4] = 1;

        matrix[3][0] = 0;
        matrix[3][1] = 4;
        matrix[3][2] = 4;
        matrix[3][3] = 5;
        matrix[3][4] = 6;

        matrix[4][0] = 0;
        matrix[4][1] = 4;
        matrix[4][2] = 4;
        matrix[4][3] = 5;
        matrix[4][4] = 6;
        return matrix;
    }
}

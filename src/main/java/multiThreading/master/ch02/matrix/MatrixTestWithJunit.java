package multiThreading.master.ch02.matrix;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * 测试行列式计算的正确性。
 *
 * @author chenyuqun
 * @date 2021/1/13 3:11 下午
 */
public class MatrixTestWithJunit {

    private static double[][] matrix1;

    private static double[][] matrix2;

    private static double[][] standard;

    public static double EPSILON = 0.000000001;

    @BeforeClass
    public static void init() {
        matrix1 = MatrixGenerator.getFixedMatrix1();
        matrix2 = MatrixGenerator.getFixedMatrix2();
        standard = new double[5][5];
        SerialMultiplier.multiply(matrix1, matrix2, standard);
        printMatrix(matrix1, "matrix1");
        printMatrix(matrix2, "matrix2");
        printMatrix(standard, "standard");
    }

    @Test
    public void testIndividual() {
        double[][] individualResult = new double[5][5];
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, individualResult);
        checkEqual(individualResult);
    }

    @Test
    public void testRow() {
        double[][] rowResult = new double[5][5];
        ParallelRowMultiplier.multiply(matrix1, matrix2, rowResult);
        printMatrix(rowResult,"rowResult");
        checkEqual(rowResult);
    }

    @Test
    public void testGroup() {
        double[][] groupResult = new double[5][5];
        ParallelGroupMultiplier.multiply(matrix1, matrix2, groupResult);
        printMatrix(groupResult, "groupResult");
        checkEqual(groupResult);
    }

    public static void printMatrix(double[][] matrix, String name) {
        System.out.println(name + ":");
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.0f, ", matrix[i][j]);
            }
            System.out.println();
        }
    }


    @Test
    public void test1() {
        Map<String, String> str = Maps.newHashMap();
        str.put("a", null);
    }

    public static void checkEqual(double[][] result) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Assert.assertTrue(Math.abs(result[i][j] - standard[i][j]) < EPSILON);
            }
        }
    }
}

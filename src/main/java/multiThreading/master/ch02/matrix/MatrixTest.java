package multiThreading.master.ch02.matrix;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 测试行列式计算的性能
 *
 * @author chenyuqun
 * @date 2021/1/12 4:58 下午
 */
@BenchmarkMode(Mode.AverageTime)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
public class MatrixTest {
    @Param(value = {"500","1000","2000"})
    private static int n;

    private double[][] matrix1;

    private double[][] matrix2;

    private double[][] result;

    @Setup
    public void init() {
        matrix1 = MatrixGenerator.map.get(n);
        matrix2 = MatrixGenerator.map.get(n);
        result = new double[n][n];
    }

    @Benchmark
    public void testSerial() {
        SerialMultiplier.multiply(matrix1, matrix2, result);
    }

    @Benchmark
    public void testParallelIndividualMultiplier() {
        double[][] result = new double[n][n];
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, result);
    }

    @Benchmark
    public void testParallelRowMultiplier() {
        double[][] result = new double[n][n];
        ParallelRowMultiplier.multiply(matrix1, matrix2, result);
    }


    @Benchmark
    public void testParallelGroupMultiplier() {
        double[][] result = new double[n][n];
        ParallelGroupMultiplier.multiply(matrix1, matrix2, result);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(MatrixTest.class.getSimpleName()).result("src/main/java/multiThreading/master/ch02/matrix/matrixResult.text").resultFormat(ResultFormatType.TEXT).build();
        new Runner(options).run();
    }
}

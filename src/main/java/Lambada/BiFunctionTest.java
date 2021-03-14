package Lambada;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author:liyongyong
 * @description: BiFunction接口学习
 * @date 2019/1/21
 */
public class BiFunctionTest {
    public static void main(String[] args) {
        BiFunctionTest test = new BiFunctionTest();
        //实现四则运算
        System.out.println(test.compute(4, 2, (value1, value2) -> value1 + value2));
        System.out.println(test.compute(4, 2, (v1, v2) -> v1 - v2));
        System.out.println(test.compute(1, 2, (v1, v2) -> v1 * v2));
        System.out.println(test.compute(3, 2, (v1, v2) -> v1 / v2));
        System.out.println(test.calculate(3, 4, (v1, v2) -> v1 + v2, v -> v * v));
    }

    public int compute(int num1, int num2, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(num1, num2);
    }

    public int calculate(int num1, int num2, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        //调用addThen首先对接收的两个参数进行biFunction的apply，然后在进行function的apply
        return biFunction.andThen(function).apply(num1, num2);
    }

    @Test
    public void test1() {
        BiFunction<Integer, Integer, Integer> biFunction = (integer, integer2) -> addTwoSum(integer, integer2);
        System.out.println(biFunction.apply(4,5));
    }

    @Test
    public void test2() {
        long a = (long) ((150 / 100D) * 100L);
        System.out.println(a);
    }

    public int addTwoSum(int a, int b) {
        return a + b;
    }

    @Test
    public void test3() {
        Integer a = 534;
        System.out.println(534 == a);
    }
}

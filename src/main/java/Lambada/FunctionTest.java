package Lambada;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author chenyuqun
 * https://developer.ibm.com/zh/articles/j-understanding-functional-programming-2/
 */
public class FunctionTest {
    /****************function******************/
    @Test
    public void testFunction() {
        // Function, input one param, output one param
        Function<Integer, Integer> function = i -> i + 1;
        Assert.assertEquals(4, (int) function.apply(3));

        // BiFunction, input two param, output one param
        BiFunction<Integer, Integer, Integer> biFunction = (num1, num2) -> num1 * num2;
        Assert.assertEquals(12, (int) biFunction.apply(3, 4));

        // apply biFunction into function
        Assert.assertEquals(13, (int) biFunction.andThen(function).apply(3, 4));
    }

    @Test
    public void testFunction2() {
        Function<Integer, Integer> function1 = i -> i + 1;
        int i = 7;
        Function<Function, Integer> function2 = function -> ((int) function.apply(i)) * 3;
        Assert.assertEquals(24, (int) function2.apply(function1));
    }

    /**
     * Consumer: input one, output none
     */
    @Test
    public void testConsumer() {
        final int[] array1 = new int[1];
        final int[] array2 = new int[1];
        Consumer<Integer> consumer1 = i -> array1[0] = i;
        Consumer<Integer> consumer2 = i -> array2[0] = array1[0] + i;
        consumer1.accept(4);
        Assert.assertEquals(4, array1[0]);
        consumer1.andThen(consumer2).accept(5);
        Assert.assertEquals(5, array1[0]);
        Assert.assertEquals(10, array2[0]);
    }

    /**
     * Supplier:input none, output one
     */
    @Test
    public void testSupplier() {
        final int[] c = new int[1];
        Supplier<Integer> supplier = () -> {
            c[0] = 10;
            return 7;
        };
        Assert.assertEquals(7, (int) supplier.get());
        Assert.assertEquals(10, c[0]);
    }

    /**
     * Precondition:input one, output boolean
     */
    @Test
    public void testPrecondition() {
        Predicate<Integer> predicate = i -> i == 10;
        Assert.assertFalse(predicate.test(8));
        Assert.assertTrue(predicate.test(10));
    }

    /*****************reduce********************/
    /**
     * reduce
     * 1 init one value
     * 2 iterator
     * 3 update init value
     * <pre>{@code
     *      function(iterable, updateValue, initialValue) {
     *          value = initialValue
     *          loop(iterable) {
     *              value = updateValue(value, currentValue)
     *          }
     *          return value
     *      }
     * }
     * </pre>
     * }
     */

    @Test
    public void testReduce() {
        int[] marks = {60, 70, 80, 90, 65, 75, 85, 95};
        int maxMark = 0;
        for (int mark : marks) {
            if (mark > maxMark) {
                maxMark = mark;
            }
        }
        System.out.println(maxMark);

        BigDecimal[] prices = {BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4), BigDecimal.valueOf(5.5)};
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            totalPrice = totalPrice.add(price);
        }
        System.out.println(totalPrice);

        Assert.assertEquals(maxMark, Arrays.stream(marks).reduce(0, (init, mark) -> Math.max(init, mark)));
        Assert.assertEquals(totalPrice, Arrays.stream(prices).reduce(BigDecimal.ZERO, (init, price) -> init.add(price)));
    }

    /**
     *
     */
    @Test
    public void testHighOrderFunction() {
        // this is Integer, if is int, the filter param is IntPredicate
        Integer[] arrays = {1, 2, 3};
        Arrays.stream(arrays).filter(notEqual(1)).forEach(System.out::println);

        int[] arrays2 = {1, 2, 3, 4};
        Arrays.stream(arrays2).filter(intNotEqual(1)).forEach(System.out::println);
    }


    private static <T> Predicate<T> notEqual(T t) {
        return (v) -> !Objects.equals(v, t);
    }

    private static IntPredicate intNotEqual(int t) {
        return v -> v != t;
    }

    /************partialFunction************/

    @Test
    public void testPartialFunction() {
        BiFunction<Integer, Integer, Integer> biFunction = (v1, v2) -> v1 - v2;

        // λx.10 - x;
        Function<Integer, Integer> subtractFrom10 = partialLeft(biFunction, 10);
        Assert.assertEquals(5, (int) subtractFrom10.apply(5));

        //λx.x - 10;
        Function<Integer, Integer> subtractBy10 = partialRight(biFunction, 10);
        Assert.assertEquals(-5, (int) subtractBy10.apply(5));
    }

    private static <T, U, R> Function<U, R> partialLeft(BiFunction<T,
            U, R> biFunction, T t) {
        return (u) -> biFunction.apply(t, u);
    }

    private static <T, U, R> Function<T, R> partialRight(BiFunction<T,
            U, R> biFunction, U u) {
        return (t) -> biFunction.apply(t, u);
    }

    /**************closure*********************/

    /**
     * in javaScript, this is a closure
     * <pre>{@code
     * function idGenerator(initialValue) {
     *      let count = initialValue;
     *      return function() {
     *          return count++;
     *      };
     * }
     * let genId = idGenerator(0);
     * genId(); // 0
     * genId(); // 1
     * }</pre>
     * ​
     * important document:
     * 1、the return is a function
     * 2、this function has lexical scope
     * <p>
     * the method of idGenerator return is a function
     * the return use count value
     * <p>
     * the target of closure: close free variable ， implement internal state.
     * free variable is stored in heap. The language that support closure must has garbage collection mechanism , otherwise, the free variable can not be released.
     */
    @Test
    public void testClosure() {
        Function<Integer, Integer> idGenerator1 = idGenerator(0);
        Assert.assertEquals(1, (int) idGenerator1.apply(1));
        Assert.assertEquals(2, (int) idGenerator1.apply(2));

        Function<Integer, Integer> idGenerator2 = idGenerator(1);
        Assert.assertEquals(1, (int) idGenerator2.apply(1));
        Assert.assertEquals(2, (int) idGenerator2.apply(2));
    }

    private Function<Integer, Integer> idGenerator(int initialValue) {
        // count store in heap
        final int[] count = {initialValue};
        return a -> {
            count[0]++;
            System.out.println("count: " + count[0]);
            return a;
        };
    }

    /****************recursion**************/
    @Test
    public void testFact() {
        Assert.assertEquals(fact_recursion(10), fact_loop(10));
    }

    private int fact_recursion(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact_recursion(n - 1);
    }

    private int fact_loop(int n) {
        int re = 1;
        for (int i = n; i > 0; i--) {
            re *= i;
        }
        return re;
    }

}

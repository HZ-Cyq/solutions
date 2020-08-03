package Lambada;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.Function4;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Value;
import io.vavr.collection.Stream;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://developer.ibm.com/zh/articles/j-understanding-functional-programming-4/
 *
 * @author chenyuqun
 */
public class VavrTest {

    @Test
    public void testTuple() {
        // set里的元素是相同的类，数量不固定
        // tuple里的元素可以是不同的类，而且数量固定
        Tuple2<String, Integer> tuple2 = Tuple.of("Hello", 100);
        tuple2.map(String::toUpperCase, v -> v * 5).apply((str, number) -> {
            String result = String.join(",", str, String.valueOf(number));
            System.out.println(result);
            return null;
        });
    }

    @Test
    public void testCompose() {
        Function3<Integer, Integer, Integer, Integer> function3 = (v1, v2, v3) -> (v1 + v2) * v3;
        Function3<Integer, Integer, Integer, Integer> composed = function3.andThen(v -> v * 100);
        // 先apply function3, 再apply addThen里的Lambda
        assertEquals((1 + 2) * 3 * 100, (int) composed.apply(1, 2, 3));

        // 先apply compose里的Lambda, 再apply function1
        int num = 4;
        Function1<Integer, Integer> function1 = v -> v + 1;
        Function<Integer, Integer> compose = function1.compose(v -> v * 2);
        assertEquals(num * 2 + 1, (int) compose.apply(num));
    }

    /**
     * 部分应用
     */
    @Test
    public void testPartial() {
        Function4<Integer, Integer, Integer, Integer, Integer> function4 =
                (v1, v2, v3, v4) -> (v1 + v2) - (v3 + v4);
        Function2<Integer, Integer, Integer> function2 = function4.apply(1, 2);
        int result = function2.apply(4, 5);
        assertEquals(-6, result);
    }

    @Test
    public void testCurried() {
        Function4<Integer, Integer, Integer, Integer, Integer> function4 = (v1, v2, v3, v4) -> v1 + v2 * v3 * v4;
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int value4 = 4;
        int expectValue = value1 + value2 * value3 * value4;
        assertEquals(expectValue, (int) function4.curried().apply(value1).curried().apply(value2).curried().apply(value3).curried().apply(value4));
        assertEquals(expectValue, (int) function4.apply(value1).apply(value2).apply(value3).apply(value4));
    }

    /**********看不明白**********/
    @Test
    public void testMemorized() {
        Function2<BigInteger, Integer, BigInteger> pow = BigInteger::pow;
        Function2<BigInteger, Integer, BigInteger> memoized = pow.memoized();
        long start = System.currentTimeMillis();
        memoized.apply(BigInteger.valueOf(1024), 1024);
        long end1 = System.currentTimeMillis();
        memoized.apply(BigInteger.valueOf(1024), 1024);
        long end2 = System.currentTimeMillis();
        System.out.printf("%d ms -> %d ms", end1 - start, end2 - end1);
    }

    /**************值***************/

    /**
     * https://blog.csdn.net/jklizxcqwe/article/details/102776133
     */

    /**
     * Option: 包装null值，避免显示的null值检查
     */
    @Test
    public void testOption() {
        Option<Object> none = Option.of(null);
        Option<Object> some = Option.of("hello");

        // 空被包装成None,非空被包装成Some
        Assert.assertEquals("None", none.toString());
        Assert.assertEquals("Some(hello)", some.toString());

        Assert.assertEquals("hello", some.get());
        Assert.assertEquals("", none.getOrElse(""));

        none.map(ele -> ele + " ").forEach(System.out::println);
        some.map(ele -> ele + " ").forEach(System.out::println);
    }

    /**
     * Either: 代表两种可能类型的值，要么是left,要么是right。一般认为Left包含错误和无效值，Right包含正确或有效值。当Either结果为Right时，可以促发map,flatmap等操作
     */
    @Test
    public void testEither() {
        Supplier<Either<Throwable, String>> compute = () -> new Random().nextBoolean() ? Either.left(new RuntimeException("Boom!")) : Either.right("Hello");

        Either<String, String> either = compute.get().map(str -> str + "World").mapLeft(Throwable::getMessage);
        System.out.println(either.isRight() ? either.get() : either.getLeft());
    }

    /**
     * Try: 包装一个可能产生异常的计算，不在代码中显式的使用try/catch拦截异常.
     */
    @Test
    public void testTry() {
        Try<Integer> result = Try.of(() -> 1 / 0);
        assertFalse(result.isSuccess());
        assertTrue(result.isFailure());
        assertEquals(-1, (int) result.getOrElse(-1));
        assertEquals(-1, (int) result.recover(e -> -1).get());

        // finally
        result.andFinally(() -> System.out.println("资源释放"));
        // 返回either对象
        Either<Throwable, Integer> either = result.toEither();
        // 抛出异常
        result.getOrElseThrow(e -> new ArithmeticException(e.getMessage()));
    }

    @Test
    public void testLazy() {
        Lazy<BigInteger> lazy = Lazy.of(() -> BigInteger.valueOf(1024).pow(1204));
        assertFalse(lazy.isEvaluated());
        lazy.get();
        assertTrue(lazy.isEvaluated());
    }

    /**************数据结构****************/
    @Test
    public void testStream() {
        System.out.println("hello world");

    }
}

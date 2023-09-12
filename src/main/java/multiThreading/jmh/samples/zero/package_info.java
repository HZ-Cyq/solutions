package multiThreading.jmh.samples.zero;

/**
 * 参考:<a href="https://blog.csdn.net/u014282578/article/details/127952593">...</a>
 * 1、使用传统的计时方法进行测试，是不靠谱的
 * {@link JmhApp1#main(String[])}
 * 2、一个简单的例子,比较ArrayList和LinkedList的add方法的执行效率
 * {@link JmhApp2#main(String[])}
 * 3、基本用法
 * (@link @Benchmark}注解：只有加了这个注解的方法才会对其执行基准测试(如果一个类中没有Benchmark注解的方法，对其进行基准测试会抛异常)
 * {@link @Warmup}注解：预热，在基准测试代码正式度量之前，先对其进行预热，使得代码的执行经历了类的早期优化、JVM运行期编译、JIT优化之后的最终状态，从而能够获得代码真实的性能数据。
 *    参数：
 *
 */

public class package_info {

}

package multiThreading.jmh.samples.zero;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/8
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JmhApp2 {
    private List<String> arrayList;

    private List<String> linkedList;

    @Setup(Level.Iteration)
    public void setUp() {
        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
    }

//    @Benchmark
    public List<String> arrayListAdd() {
        this.arrayList.add("测试数据");
        return arrayList;
    }

//    @Benchmark
    public List<String> linkedListAdd() {
        this.linkedList.add("测试数据");
        return this.linkedList;
    }

    public static void main(String[] args) throws RunnerException {
        Options opts = new OptionsBuilder().include(JmhApp2.class.getSimpleName()).
                forks(1).measurementIterations(10).warmupIterations(10).build();
        new Runner(opts).run();
    }
}

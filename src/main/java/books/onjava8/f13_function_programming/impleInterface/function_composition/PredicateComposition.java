package books.onjava8.f13_function_programming.impleInterface.function_composition;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/5/31 6:11 下午
 */
public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
    // 不等于"bar"并且长度小于5 或者 包含 "foo"
            p4 = p1.negate().and(p2).or(p3);
    public static void main(String[] args) {
        Stream.of("bar", "foobar", "foobaz", "fongopuckey","hi")
                .filter(p4)
                .forEach(System.out::println);
    }
}

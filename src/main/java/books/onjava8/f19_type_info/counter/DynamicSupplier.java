package books.onjava8.f19_type_info.counter;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author chenyuqun
 * @date 2021/5/17 1:36 下午
 */
public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Stream.generate(
                new DynamicSupplier<>(CountedInteger.class))
                // 跳过[0,10)
                .skip(10)
                // 接取[10,15]
                .limit(5)
                .forEach(System.out::println);
    }
}

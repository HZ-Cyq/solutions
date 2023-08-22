package books.onjava8.f19_type_info.taginterface;

import java.util.function.Supplier;

/**
 * @author chenyuqun
 * @date 2021/5/21 2:48 下午
 */
public class Operation {
    public final Supplier<String>  description;
    public final Runnable command;

    public Operation(Supplier<String> description, Runnable command) {
        this.description = description;
        this.command = command;
    }
}

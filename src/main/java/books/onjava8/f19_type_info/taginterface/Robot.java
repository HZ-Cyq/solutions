package books.onjava8.f19_type_info.taginterface;


import java.util.List;

/**
 * @author chenyuqun
 * @date 2021/5/21 2:49 下午
 */
public interface Robot {
    String name();

    String model();

    List<Operation> operations();

    /**
     * 打印robot信息，执行robot命令.
     * @param r
     */
    static void test(Robot r) {
        if (r instanceof Null) {
            System.out.println("[Null Robot]");
        }
        System.out.println("Robot name: " + r.name());
        System.out.println("Robot model: " + r.model());
        for (Operation operation : r.operations()) {
            System.out.println(operation.description.get());
            operation.command.run();
        }

    }
}

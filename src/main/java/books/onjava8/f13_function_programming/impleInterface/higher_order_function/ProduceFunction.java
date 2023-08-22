package books.onjava8.f13_function_programming.impleInterface.higher_order_function;

/**
 * @author chenyuqun
 * @date 2021/5/31 2:24 下午
 */
public class ProduceFunction {
    public static FuncSS produce() {
        return String::toLowerCase;
    }

    public static void main(String[] args) {
        FuncSS funcSS = ProduceFunction.produce();
        System.out.println(funcSS.apply("Hello World"));
    }
}

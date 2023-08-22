package books.onjava8.f13_function_programming.impleInterface.lambda;

/**
 * @author chenyuqun
 * @date 2021/5/27 4:01 下午
 */
public class ConcreteStrategy implements Strategy {
    @Override
    public String approach(String msg) {
        return "In ConcreteStrategy, the msg is {" + msg + "}";
    }
}

package books.onjava8.f13_function_programming.impleInterface.lambda;

/**
 * @author chenyuqun
 * @date 2021/5/26 9:24 下午
 */
public class Strategize {
    public static void main(String[] args) {
        // 1、子类
        Strategy strategy1 = new ConcreteStrategy();
        // 2、匿名内部类
        Strategy strategy2 = new Strategy() {
            @Override
            public String approach(String msg) {
                return "in Anonymous class, the msg is {" + msg + "}";
            }
        };
        // 3、方法引用
        Strategy strategy3 = UnRelated::UnRelatedMethod;
        // 4、Lambda表达式
        Strategy strategy4 = msg -> "In lambda expression, the meg is {" + msg + "}";

        Strategy[] strategies = new Strategy[]{strategy1, strategy2,strategy3, strategy4};
        for (Strategy strategy : strategies) {
            // 每次调用approach方法，会产生不同的行为，具体取决于此刻正在使用的策略。我们传递的是行为，而并非仅仅是数据
            System.out.println(strategy.approach("hello world, today is 2021-05-27"));
        }
    }
}

package design_pattern.behavioral.strategy;

/**
 * @author playcrab_chenyuqun
 */
@StrategyAnnotation(type = "A")
public class ConcreteStrategyA implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyA implement algorithm");
    }
}

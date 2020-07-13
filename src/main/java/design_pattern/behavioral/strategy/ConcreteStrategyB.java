package design_pattern.behavioral.strategy;

/**
 * @author playcrab_chenyuqun
 */
@StrategyAnnotation(type = "B")
public class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyB implement algorithm");
    }
}

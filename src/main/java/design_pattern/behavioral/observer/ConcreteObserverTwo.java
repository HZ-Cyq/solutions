package design_pattern.behavioral.observer;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo update");
    }
}

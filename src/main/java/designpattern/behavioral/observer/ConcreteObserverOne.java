package designpattern.behavioral.observer;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("concreteObserverOne update");
    }
}

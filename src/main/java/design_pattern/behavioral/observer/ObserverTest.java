package design_pattern.behavioral.observer;

import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class ObserverTest {
    @Test
    public void testObserver() {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserverOne();
        Observer observer2 = new ConcreteObserverTwo();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObservers(new Message());

        subject.removeObserver(observer1);
        subject.notifyObservers(new Message());
    }
}

package design_pattern.behavioral.observer.eventbus.realization;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class EventBusTest {
    @Test
    public void testEventBus() {
        UserController userController = new UserController();

        List<Object> observers = new LinkedList<>();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        observers.add(observer1);
        observers.add(observer2);
        userController.setRegObserver(observers);

        userController.register("12345", "67890");
    }
}

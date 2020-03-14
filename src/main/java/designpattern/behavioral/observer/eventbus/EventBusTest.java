package designpattern.behavioral.observer.eventbus;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class EventBusTest {
    @Test
    public void test1() {
        UserController userController = new UserController();

        List<Object> observers = new LinkedList<>();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        observers.add(regPromotionObserver);
        observers.add(regNotificationObserver);
        userController.setRegObserver(observers);

        userController.register("12345","67890");
    }
}

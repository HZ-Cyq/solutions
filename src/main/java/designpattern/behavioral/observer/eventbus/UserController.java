package designpattern.behavioral.observer.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import designpattern.behavioral.observer.eventbus.realization.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author playcrab_chenyuqun
 */
public class UserController {
    private UserService userService = new UserService();

    private EventBus eventBus;
    private int DEFAULT_EVENT_BUS_THREAD_POOL_SIZE = 20;

    /**
     * 初始化eventBus
     */
    public UserController() {
        // 同步阻塞
        eventBus = new EventBus();
        // 异步非阻塞
        // eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENT_BUS_THREAD_POOL_SIZE));
    }

    /**
     * 在eventBus中注册观察者。
     * @param observers
     */
    public void setRegObserver(List<Object> observers) {
        System.out.println("将观察者注册到eventBus中");
        observers.forEach(observer -> eventBus.register(observer));
    }

    public Long register(String telephone, String password) {
        Long userId = userService.register(telephone, password);
        int useIdInt = Math.toIntExact(userId);

        MessageLong messageLong = new MessageLong(userId);
        MessageLongSub messageLongSub = new MessageLongSub(userId);
        MessageInt messageInt = new MessageInt(useIdInt);

        System.out.println("发送messageLong类型的信息");
        eventBus.post(messageLong);

        System.out.println("发送messageLongSub类型的信息");
        eventBus.post(messageLongSub);

        System.out.println("发送messageInt类型的信息");
        eventBus.post(messageInt);

        return userId;
    }
}

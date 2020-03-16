package designpattern.behavioral.observer.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @author playcrab_chenyuqun
 */
public class RegNotificationObserver {

    @Subscribe
    public void handleRegSuccess(MessageLong userId) {
        System.out.println("RegNotificationObserver 处理MessageLong类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageLongSub userId) {
        System.out.println("RegNotificationObserver 处理MessageLongSub类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageInt userId) {
        System.out.println("RegNotificationObserver 处理MessageInt类型的信息：" + userId.getVal());
    }

}
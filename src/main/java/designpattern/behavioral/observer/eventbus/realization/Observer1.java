package designpattern.behavioral.observer.eventbus.realization;

import designpattern.behavioral.observer.eventbus.MessageInt;
import designpattern.behavioral.observer.eventbus.MessageLong;
import designpattern.behavioral.observer.eventbus.MessageLongSub;

/**
 * @author playcrab_chenyuqun
 */
public class Observer1 {
    @Subscribe
    public void handleRegSuccess(MessageLong userId) {
        System.out.println("Observer1 处理MessageLong类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageLongSub userId) {
        System.out.println("Observer1 处理MessageLongSub类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageInt userId) {
        System.out.println("Observer1 处理MessageInt类型的信息：" + userId.getVal());
    }
}

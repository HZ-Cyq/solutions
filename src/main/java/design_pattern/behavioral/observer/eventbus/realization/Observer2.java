package design_pattern.behavioral.observer.eventbus.realization;

import design_pattern.behavioral.observer.eventbus.MessageInt;
import design_pattern.behavioral.observer.eventbus.MessageLong;
import design_pattern.behavioral.observer.eventbus.MessageLongSub;

/**
 * @author playcrab_chenyuqun
 */
public class Observer2 {
    @Subscribe
    public void handleRegSuccess(MessageLong userId) {
        System.out.println("Observer2 处理MessageLong类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageLongSub userId) {
        System.out.println("Observer2 处理MessageLongSub类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageInt userId) {
        System.out.println("Observer2 处理MessageInt类型的信息：" + userId.getVal());
    }
}

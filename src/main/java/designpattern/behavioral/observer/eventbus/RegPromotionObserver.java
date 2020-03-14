package designpattern.behavioral.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author playcrab_chenyuqun
 */
public class RegPromotionObserver {

    @Subscribe
    public void handleRegSuccess(MessageLong userId) {
        System.out.println("RegPromotionObserver 处理MessageLong类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageLongSub userId) {
        System.out.println("RegPromotionObserver 处理MessageLongSub类型的信息：" + userId.getVal());
    }

    @Subscribe
    public void handleRegSuccess(MessageInt userId) {
        System.out.println("RegPromotionObserver 处理MessageInt类型的信息：" + userId.getVal());
    }

}

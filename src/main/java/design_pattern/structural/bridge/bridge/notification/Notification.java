package design_pattern.structural.bridge.bridge.notification;

import design_pattern.structural.bridge.bridge.sender.MsgSender;

/**
 * @author chenyuqun
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void cNotify(String message);
}

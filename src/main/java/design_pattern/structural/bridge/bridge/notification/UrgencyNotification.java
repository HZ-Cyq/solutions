package design_pattern.structural.bridge.bridge.notification;

import design_pattern.structural.bridge.bridge.sender.MsgSender;

/**
 * @author chenyuqun
 */
public class UrgencyNotification extends Notification{
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void cNotify(String message) {
        msgSender.send(message);
    }
}

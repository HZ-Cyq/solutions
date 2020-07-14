package design_pattern.structural.bridge.prime;

import design_pattern.structural.bridge.NotificationEmergencyLevel;

import java.util.List;

/**
 * @author chenyuqun
 */
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;

    public Notification() {
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
            System.out.println("Notification notify: SEVERE");
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
            System.out.println("Notification notify: URGENCY");
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //... 发邮件
            System.out.println("Notification notify: NORMAL");
        }
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public List<String> getWechatIds() {
        return wechatIds;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }
}

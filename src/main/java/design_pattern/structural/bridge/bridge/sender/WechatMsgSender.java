package design_pattern.structural.bridge.bridge.sender;

import java.util.List;

/**
 * @author chenyuqun
 */
public class WechatMsgSender implements MsgSender {
    private List<String> wechatId;
    @Override
    public void send(String message) {
        System.out.println("send wechat massage");
    }
}

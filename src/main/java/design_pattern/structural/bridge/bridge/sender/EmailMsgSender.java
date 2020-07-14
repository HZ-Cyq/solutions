package design_pattern.structural.bridge.bridge.sender;

import java.util.List;

/**
 * @author chenyuqun
 */
public class EmailMsgSender implements MsgSender {
    private List<String> email;
    @Override
    public void send(String message) {
        System.out.println("send email message");
    }
}

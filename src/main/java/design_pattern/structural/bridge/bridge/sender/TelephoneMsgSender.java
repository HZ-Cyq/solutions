package design_pattern.structural.bridge.bridge.sender;

import java.util.List;

/**
 * @author chenyuqun
 */
public class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;

    @Override
    public void send(String message) {
        System.out.println("send telephone message");
    }

}

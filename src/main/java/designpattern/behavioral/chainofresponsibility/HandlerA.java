package designpattern.behavioral.chainofresponsibility;

/**
 * @author playcrab_chenyuqun
 */
public class HandlerA extends Handler{
    @Override
    public void handle() {
        Boolean handled = false;
        if(handled) {
            getSuccessor().handle();
        }
    }
}

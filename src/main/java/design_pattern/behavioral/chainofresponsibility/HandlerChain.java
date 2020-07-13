package design_pattern.behavioral.chainofresponsibility;

/**
 * @author playcrab_chenyuqun
 */
public class HandlerChain {
    Handler head = null;
    Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if(head == null) {
            head = handler;
            tail = handler;
            return ;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handler() {
        if(head == null || tail == null) {
            return ;
        }
        head.handle();
    }

}

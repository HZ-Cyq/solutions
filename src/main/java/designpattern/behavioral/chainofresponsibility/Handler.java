package designpattern.behavioral.chainofresponsibility;

/**
 * @author playcrab_chenyuqun
 */
public abstract class Handler {
    private Handler successor;

    public abstract void handle();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

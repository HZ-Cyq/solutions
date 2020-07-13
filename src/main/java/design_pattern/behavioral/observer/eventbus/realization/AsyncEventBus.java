package design_pattern.behavioral.observer.eventbus.realization;

import java.util.concurrent.Executor;

/**
 * @author playcrab_chenyuqun
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}

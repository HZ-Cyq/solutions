package innerclass.timer;

/**
 * @author playcrab_chenyuqun
 */
public class TimeExecute {
    public void reset(ITimeExecute action) {
        action.onResetTime(10);
    }
}

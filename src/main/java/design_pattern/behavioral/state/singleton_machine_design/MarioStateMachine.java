package design_pattern.behavioral.state.singleton_machine_design;

/**
 * 状态机的实现模式三：单例的状态模式
 *
 * @author chenyuqun
 */
public class MarioStateMachine {
    // 当前的状态
    private IMario currentState;
    private int score;

    public MarioStateMachine() {
        currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        currentState.obtainCape(this);
    }

    public void obtainFire() {
        currentState.obtainFire(this);
    }

    public void meetMonster() {
        currentState.meetMonster(this);
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

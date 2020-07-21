package design_pattern.behavioral.state.machine_design;


/**
 * 状态机的实现方式三：状态模式
 * @author chenyuqun
 */
public class MarioStateMachine {
    IMario currentState;
    private int score;

    public void obtainMushRoom() {
        currentState.obtainMushRoom();
    }

    public void obtainCape() {
        currentState.obtainCape();
    }

    public void obtainFire() {
        currentState.obtainFire();
    }

    public void meetMonster() {
        currentState.meetMonster();
    }

    public MarioStateMachine() {
        currentState = new SmallMario(this);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}

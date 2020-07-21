package design_pattern.behavioral.state.branch_logic;

import static design_pattern.behavioral.state.branch_logic.State.CAPE;
import static design_pattern.behavioral.state.branch_logic.State.FIRE;
import static design_pattern.behavioral.state.branch_logic.State.SMALL;
import static design_pattern.behavioral.state.branch_logic.State.SUPER;

/**
 * 状态机的实现方式一：分支逻辑
 * @author chenyuqun
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtainMushRoom() {
        if (currentState.equals(SMALL)) {
            currentState = SUPER;
            score += 100;
        }
    }

    public void obtainCape() {
        if (currentState.equals(SMALL)) {
            currentState = CAPE;
            score += 200;
        } else if (currentState.equals(SUPER)) {
            currentState = CAPE;
            score += 200;
        }
    }

    public void obtainFire() {
        if (currentState.equals(SMALL)) {
            currentState = FIRE;
            score += 300;
        } else if (currentState.equals(SUPER)) {
            currentState = FIRE;
            score += 300;
        }
    }

    public void meetMonster() {
        if (currentState.equals(SUPER)) {
            currentState = SMALL;
            score -= 100;
        } else if (currentState.equals(CAPE)) {
            currentState = SMALL;
            score -= 200;
        } else if (currentState.equals(FIRE)) {
            currentState = SMALL;
            score -= 300;
        }
    }
}

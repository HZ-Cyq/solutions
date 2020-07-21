package design_pattern.behavioral.state.look_up_table;

import static design_pattern.behavioral.state.look_up_table.MarioStateMachine.State.CAPE;
import static design_pattern.behavioral.state.look_up_table.MarioStateMachine.State.FIRE;
import static design_pattern.behavioral.state.look_up_table.MarioStateMachine.State.SMALL;
import static design_pattern.behavioral.state.look_up_table.MarioStateMachine.State.SUPER;

/**
 * 状态机的实现方式二：查表法
 * @author chenyuqun
 */
public class MarioStateMachine {
    private State currentState;
    private int score;
    private static final State[][] transitionTable = {{SMALL, CAPE, FIRE, SMALL}, {SUPER, CAPE, FIRE, SMALL}, {CAPE, CAPE, CAPE, SMALL}, {FIRE, FIRE, FIRE, SMALL}};
    private static final int[][] scoreTable = {{100, 200, 300, 0}, {0, 200, 300, -100}, {0, 0, 0, -200}, {0, 0, 0, -300}};

    public MarioStateMachine() {
        currentState = SMALL;
        score = 0;
    }

    public void executeEvent(Event event) {
        score = score + scoreTable[currentState.code][event.code];
        currentState = transitionTable[currentState.code][event.code];
    }

    public enum State {
        SMALL(0),
        SUPER(1),
        CAPE(2),
        FIRE(3);

        private int code;

        State(int code) {
            this.code = code;
        }
    }

    enum Event {
        GOT_MUSHROOM(0),
        GOT_CAPE(1),
        COTE_FIRE(2),
        MET_MONSTER(3),
        ;

        private int code;

        Event(int code) {
            this.code = code;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

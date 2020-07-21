package design_pattern.behavioral.state.machine_design;

import static design_pattern.behavioral.state.machine_design.State.SMALL;

/**
 * @author chenyuqun
 */
public class CapeMario implements IMario {
    MarioStateMachine marioStateMachine;

    public CapeMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFire() {

    }

    @Override
    public void meetMonster() {
        marioStateMachine.setCurrentState(new SmallMario(marioStateMachine));
        marioStateMachine.setScore(marioStateMachine.getScore() - 200);
    }
}

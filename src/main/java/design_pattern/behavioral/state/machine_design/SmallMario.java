package design_pattern.behavioral.state.machine_design;

/**
 * @author chenyuqun
 */
public class SmallMario implements IMario {
    private MarioStateMachine marioStateMachine;

    public SmallMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void obtainMushRoom() {
        marioStateMachine.setCurrentState(new SuperMario(marioStateMachine));
        marioStateMachine.setScore(marioStateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape() {
        marioStateMachine.setCurrentState(new CapeMario(marioStateMachine));
        marioStateMachine.setScore(marioStateMachine.getScore() + 200);
    }

    @Override
    public void obtainFire() {
        marioStateMachine.setCurrentState(new FireMario(marioStateMachine));
        marioStateMachine.setScore(marioStateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster() {

    }
}

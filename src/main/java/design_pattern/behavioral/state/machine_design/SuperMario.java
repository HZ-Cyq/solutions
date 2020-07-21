package design_pattern.behavioral.state.machine_design;

/**
 * @author chenyuqun
 */
public class SuperMario implements IMario {
    MarioStateMachine marioStateMachine;

    public SuperMario(MarioStateMachine marioStateMachine) {
        this.marioStateMachine = marioStateMachine;
    }

    @Override
    public void obtainMushRoom() {

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
        marioStateMachine.setCurrentState(new SmallMario(marioStateMachine));
        marioStateMachine.setScore(marioStateMachine.getScore() - 100);
    }
}

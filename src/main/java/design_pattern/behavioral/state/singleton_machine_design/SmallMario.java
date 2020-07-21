package design_pattern.behavioral.state.singleton_machine_design;

/**
 * @author chenyuqun
 */
public class SmallMario implements IMario {
    private static final SmallMario instance = new SmallMario();

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(SuperMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(CapeMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 200);
    }

    @Override
    public void obtainFire(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(FireMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine marioStateMachine) {

    }

    public static SmallMario getInstance() {
        return instance;
    }
}

package design_pattern.behavioral.state.singleton_machine_design;

/**
 * @author chenyuqun
 */
public class SuperMario implements IMario{
    private static final SuperMario instance = new SuperMario();
    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {

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
        marioStateMachine.setCurrentState(SmallMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() - 100);
    }

    public static SuperMario getInstance() {
        return instance;
    }
}

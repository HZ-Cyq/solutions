package design_pattern.behavioral.state.singleton_machine_design;

/**
 * @author chenyuqun
 */
public class CapeMario implements IMario{
    private static final CapeMario instance = new CapeMario();
    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {

    }

    @Override
    public void obtainFire(MarioStateMachine marioStateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(SmallMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() - 200);
    }

    public static CapeMario getInstance() {
        return instance;
    }
}

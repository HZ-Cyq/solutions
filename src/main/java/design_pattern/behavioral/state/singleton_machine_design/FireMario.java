package design_pattern.behavioral.state.singleton_machine_design;

/**
 * @author chenyuqun
 */
public class FireMario implements IMario {
    private static final FireMario instance = new FireMario();
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
        marioStateMachine.setScore(marioStateMachine.getScore() - 300);
    }

    public static FireMario getInstance() {
        return instance;
    }
}

package design_pattern.behavioral.state.singleton_machine_design;

/**
 * @author chenyuqun
 */
public interface IMario {
    void obtainMushRoom(MarioStateMachine marioStateMachine);
    void obtainCape(MarioStateMachine marioStateMachine);
    void obtainFire(MarioStateMachine marioStateMachine);
    void meetMonster(MarioStateMachine marioStateMachine);
}

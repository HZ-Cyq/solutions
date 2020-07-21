package design_pattern.behavioral.state.singleton_machine_design;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenyuqun
 */
public class MachineTest {
    @Test
    public void testMachine() {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainCape();
        Assert.assertTrue(marioStateMachine.getCurrentState().equals(CapeMario.getInstance()));
        Assert.assertEquals(marioStateMachine.getScore(), 200);
        marioStateMachine.meetMonster();
        Assert.assertTrue(marioStateMachine.getCurrentState().equals(SmallMario.getInstance()));
        Assert.assertEquals(0, marioStateMachine.getScore());
    }
}

package design_pattern.behavioral.state.machine_design;

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
        Assert.assertTrue(marioStateMachine.currentState instanceof CapeMario);
        Assert.assertEquals(marioStateMachine.getScore(), 200);
        marioStateMachine.meetMonster();
        Assert.assertTrue(marioStateMachine.currentState instanceof SmallMario);
        Assert.assertEquals(0, marioStateMachine.getScore());
    }
}
